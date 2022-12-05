package selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                String downloadDir = Paths.get("src/main/resources/downloads").toAbsolutePath().toString();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", downloadDir);
                ChromeOptions opts = new ChromeOptions();
                opts.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(opts);
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
