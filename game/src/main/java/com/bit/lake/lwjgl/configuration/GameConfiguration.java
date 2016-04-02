package com.bit.lake.lwjgl.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

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
        String localString = configuration.getString("game.default.language");
        return Locale.forLanguageTag(localString);
    }

}
