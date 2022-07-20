package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface LocalConfig extends Config {
    String platformName();
    String deviceName();
    String platformVersion();
    String appPackage();
    String appActivity();
}
