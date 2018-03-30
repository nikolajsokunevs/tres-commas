package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Properties;
import static config.ApplicationProperties.ApplicationProperty.APP_ENV;

public class ApplicationProperties {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationProperties.class);
    private static HashMap<String, Properties> DEFAULT_VALUES = new HashMap<String, Properties>() {
        {
            put("default", new Properties() {
                {
                    //timeout and wait time properties
                    setProperty(ApplicationProperty.WAIT_TIMEOUT_SHT.value, "5");
                    setProperty(ApplicationProperty.WAIT_TIMEOUT.value, "10");
                    setProperty(ApplicationProperty.WAIT_TIMEOUT_LNG.value, "30");

                    setProperty(ApplicationProperty.TARGET_BROWSER.value, "FIREFOX"); //PHANTOMJS, OPERA, SAFARI, EDGE, IE, CHROME, FIREFOX

                    //application URL's
                    setProperty(ApplicationProperty.APP_URL.value, "http://the-internet.herokuapp.com");

                    //Selenium grid settings
                    setProperty(ApplicationProperty.REMOTE_DRIVER.value, "false");
                    setProperty(ApplicationProperty.SELENIUM_GRID_URL.value, "http://selenium-hub:8080/wd/hub");

                }
            });
            put("other-dev", new Properties() {
                {
                }
            });
            put("local", new Properties() {
                {
                    setProperty(ApplicationProperty.APP_URL.value, "http://localhost:8080/");
                }
            });
            put("dev-ci", new Properties() {
                {
                    setProperty(ApplicationProperty.APP_URL.value, "http://ci_url/#");
                    setProperty(ApplicationProperty.REMOTE_DRIVER.value, "true");
                }
            });
        }

    };

    private static String getString(String propertyName) {
        String currentEnv = System.getProperties().getProperty(
                APP_ENV.value,
                System.getenv(APP_ENV.value.toUpperCase().replace('.', '_')));

        if (System.getProperties().containsKey(propertyName)) {
            return System.getProperties().getProperty(propertyName);
        }
        if (currentEnv != null) {
            if (DEFAULT_VALUES.get(currentEnv).containsKey(propertyName)) {
                return DEFAULT_VALUES.get(currentEnv).getProperty(propertyName);
            }
        }
        if (DEFAULT_VALUES.get("default").containsKey(propertyName)) {
            return DEFAULT_VALUES.get("default").getProperty(propertyName);
        }

        logger.warn("Unknown application property: " + propertyName);
        throw new RuntimeException("Unknown application property: " + propertyName);
    }

    public static String getString(ApplicationProperty property) {
        return getString(property.value);
    }

    public static Integer getInteger(ApplicationProperty property) {
        return Integer.valueOf(getString(property));
    }


    public static boolean getBoolean(ApplicationProperty property) {
        return Boolean.valueOf(getString(property));
    }

    public enum ApplicationProperty {

        APP_ENV("application.env"),
        APP_URL("application.appUrl"),
        TARGET_BROWSER("application.targetBrowser"),
        WAIT_TIMEOUT_SHT("application.timeoutShort"),
        WAIT_TIMEOUT("application.timeoutRegular"),
        WAIT_TIMEOUT_LNG("application.timeoutLong"),
        PROXY_HOST("proxy.proxyHost"), PROXY_PORT("proxy.proxyPort"),
        REMOTE_DRIVER("selenium.remoteDriver"),
        SELENIUM_GRID_URL("selenium.seleniumGridURL");

        private String value;

        ApplicationProperty(String value) {
            this.value = value;
        }
    }
}