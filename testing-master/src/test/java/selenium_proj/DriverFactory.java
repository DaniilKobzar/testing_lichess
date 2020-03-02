package selenium_proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class DriverFactory {

    private WebDriver driver;

    public WebDriver setup (String browser){

        if ("Chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications"); //Disable Web push notifications in Chrome
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("start-maximized");
            this.driver = new ChromeDriver(options);
        } else if ("Firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
            FirefoxOptions optionsFF = new FirefoxOptions();
            optionsFF.setProfile(new FirefoxProfile());
            optionsFF.addPreference("dom.webnotifications.enabled", false);
            optionsFF.addPreference("browser.helperApps.alwaysAsk.force", false);
            optionsFF.addPreference("browser.download.manager.showWhenStarting", false);
            //optionsFF.addPreference("pdfjs.disabled", true);
            optionsFF.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
            this.driver = new FirefoxDriver(optionsFF);
            driver.manage().window().maximize();
        }

        return driver;

    }
}
