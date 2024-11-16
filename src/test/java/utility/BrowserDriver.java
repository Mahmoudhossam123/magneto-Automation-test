package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class BrowserDriver {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");
            options.addArguments("--incognito");
            options.addArguments("--disable-ads");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() throws InterruptedException {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
