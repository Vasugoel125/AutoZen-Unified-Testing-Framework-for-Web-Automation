package com.tmb.config;

import java.awt.*;

public final class ConfigFactory
{
    private ConfigFactory()
    {}

    public static FrameworkConfig getConfig()
    {
        return org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);
    }
}
