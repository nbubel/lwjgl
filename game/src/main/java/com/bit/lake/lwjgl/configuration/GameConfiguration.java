package com.bit.lake.lwjgl.configuration;

import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.components.hashtag.Hashtag;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.lwjgl.opengl.DisplayMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author Patrick Wilmes
 */
public final class GameConfiguration {

    private static final Logger LOGGER = Logger.getLogger(GameConfiguration.class);

    private Configuration configuration;

    public GameConfiguration() {
        try {
            configuration = new PropertiesConfiguration("conf/game.properties");
        } catch (ConfigurationException e) {
            LOGGER.error("Cannot load game.properties. Check if properties exist!");
        }
    }

    public Locale getConfiguredLocale() {
        String localString = configuration.getString("game.default.language", "de");
        return Locale.forLanguageTag(localString);
    }

    public DisplayMode getDisplayMode() {
        int width = configuration.getInt("game.display.width", 800);
        int height = configuration.getInt("game.display.height", 600);
        return new DisplayMode(width, height);
    }

    public int getFpsLimit() {
        return configuration.getInt("game.fps.limit", 60);
    }


    public List<Hashtag> getHashtags() {
        String hashtagString = configuration.getString("game.hashtags");
        List<Hashtag> hashtags = new ArrayList<>();
        Arrays.asList(hashtagString.split(";")).forEach(hashtag -> hashtags.add(new Hashtag(0,0, "", TargetAction.quit)));
        return hashtags;
    }

}
