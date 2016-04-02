package com.bit.lake.lwjgl.twitter;

import org.junit.Test;
import twitter4j.*;

public class TwitterClientTest {

    @Test
    public void readTwitterStream() throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        //List<Status> statuses = twitter.getHomeTimeline();
        QueryResult result = twitter.search(new Query("test").locale("DE"));

        System.out.println("Showing home timeline.");
        for (Status status : result.getTweets()) {
            System.out.println(status.getUser().getName() + " : " +
                    status.getUser().getStatusesCount() + ": " +
                    status.getUser().getFollowersCount() + " : " +
                    status.getUser().getListedCount() + " : " +
                    status.getUser().getFavouritesCount() + " : " +
                    status.getUser().getFriendsCount() + " : " +
                    status.getFavoriteCount() + ": " +
                    status.getRetweetCount() + " : " +
                    getMentions(status.getUserMentionEntities()) + " : " +
                    getHashtags(status.getHashtagEntities()) + " : " +
                    status.getText());

        }
    }

    private String getHashtags(HashtagEntity[] hashtagEntities) {
        String ret = "";
        for (HashtagEntity entity :
                hashtagEntities) {
            ret += entity.getText() + " : ";
        }
        return ret;
    }

    private String getMentions(UserMentionEntity[] userMentionEntities) {
        String ret = "";
        for (UserMentionEntity entity :
                userMentionEntities) {
            ret += entity.getName();
        }
        return ret;
    }
}
