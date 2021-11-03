package driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    WebDriver driver;
    String nodeURL = "http://192.168.1.159:4444";

    public WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            driver = createDriver();
        }

        return driver;
    }

    public WebDriver createDriver() throws MalformedURLException {
        String browser = System.getProperty("browser");
        String mode = System.getProperty("mode");

        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("chromelocal")) {
            DesiredCapabilities chromeCapability = new DesiredCapabilities();
            chromeCapability.setBrowserName("chrome");
            chromeCapability.setPlatform(Platform.WIN10);
            return new RemoteWebDriver(new URL(nodeURL), chromeCapability);
        }
//        if (browser.equalsIgnoreCase("firefoxlocal")) {
//            DesiredCapabilities ffCapability = new DesiredCapabilities();
//            ffCapability.setBrowserName("firefox");
//            ffCapability.setPlatform(Platform.WIN10);
//            return new RemoteWebDriver(new URL(nodeURL), ffCapability);
//        }
        /* Appears an error when trying to run against FireFox locally - "Could not start a new session. Response code 500. Message: Could not start a new session. Could not start a new session. Error while creating session with the driver service.
        Stopping driver service: Driver server process died prematurely. Was trying with different versions of FF - the same error :( "*/
        return driver;
    }
}