package ru.qalearn.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configs {

    public static Config getConfig(String resource) {
        return ConfigFactory.parseResources(resource).resolve();
    }
}