package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static String userLogin = config.userLogin();
    static String userPassword = config.userPassword();
    static String appURL = config.appURL();
    static String deviceName = config.deviceName();
    static String osVersion = config.osVersion();
    static String browserURL = config.browserURL();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", userLogin);
        mutableCapabilities.setCapability("browserstack.key", userPassword);

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", appURL);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", deviceName);
        mutableCapabilities.setCapability("os_version", osVersion);

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "QA.GURU lesson 12/21");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}