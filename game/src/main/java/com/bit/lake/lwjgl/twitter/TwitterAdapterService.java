package com.bit.lake.lwjgl.twitter;

import twitter4j.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwitterAdapterService {

    public static final int PAG_SIZE = 30;

    public List<TwitterCardModel> getCardsFor(String tag, int numberOfCards) {
        Twitter twitter = TwitterFactory.getSingleton();
        List<TwitterCardModel> retList = new ArrayList<>();

        try {
            Set<String> users = new HashSet<>();
            long start = 0;
            do {
                mapResult(retList, users, numberOfCards,
                        twitter.search(new Query(tag)
                                .locale("DE")
                                .sinceId(start)
                                .count(PAG_SIZE)).getTweets());
                start += PAG_SIZE;
            } while (retList.size() < numberOfCards);

        } catch (TwitterException e) {
            throw new RuntimeException("Cannot connect to Twitter.", e);
        }

        return retList;
    }

    private void mapResult(List<TwitterCardModel> retList, Set<String> users, int numberOfCards, List<Status> tweets) {

        for (int i = 0; i < tweets.size(); i++) {
            Status tweet = tweets.get(i);

            if (users.contains(tweet.getUser().getName()))
                continue;

            users.add(tweet.getUser().getName());

            retList.add(mapTweet(tweet));

            if (retList.size() >= numberOfCards)
                return;
        }
    }

    private TwitterCardModel mapTweet(Status tweet) {
        TwitterCardModel model = new TwitterCardModel();
        model.setLive(tweet.getUser().getFavouritesCount() % 1000);
        model.setAttack(tweet.getUser().getFollowersCount() % 1000);
        model.setDefence(tweet.getUser().getFriendsCount() % 1000);
        model.setTitle(tweet.getUser().getName());

        model.setUserId(tweet.getUser().getId());
        model.setTweetText(tweet.getText());

        for (HashtagEntity entity :
                tweet.getHashtagEntities()) {
            model.getTags().add(entity.getText());
        }

        model.setProfileImage(readProfileImage(tweet));

        return model;
    }

    private ByteArrayInputStream readProfileImage(Status tweet) {

        try {
            URL url = new URL(tweet.getUser().getProfileImageURL());


            BufferedImage image = ImageIO.read(url.openStream());
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            ImageIO.write(image, "png", byteArrayOut);
            byte[] resultingBytes = byteArrayOut.toByteArray();
            return new ByteArrayInputStream(resultingBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
