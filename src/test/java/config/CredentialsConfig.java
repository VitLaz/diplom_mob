package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    String userLogin();
    String userPassword();
    String appURL();
    String deviceName();
    String osVersion();
    String browserURL();
}