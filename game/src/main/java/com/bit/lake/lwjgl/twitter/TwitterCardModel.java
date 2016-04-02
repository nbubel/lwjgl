package com.bit.lake.lwjgl.twitter;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class TwitterCardModel {

    private int live;
    private int attack;
    private int defence;
    private String title;
    private List<String> tags = new ArrayList<>();

    private Long userId;
    private String tweetText;
    private ByteArrayInputStream profileImage;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public ByteArrayInputStream getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ByteArrayInputStream profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "TwitterCardModel{" +
                "live=" + live +
                ", attack=" + attack +
                ", defence=" + defence +
                ", title='" + title + '\'' +
                ", tags=" + tags +
                ", userId=" + userId +
                ", tweetText='" + tweetText + '\'' +
                '}';
    }
}
