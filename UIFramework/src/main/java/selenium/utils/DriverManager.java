package selenium.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
        throw new IllegalStateException();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.getDriver(ConfigManager.readData("browsers", 1));
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
