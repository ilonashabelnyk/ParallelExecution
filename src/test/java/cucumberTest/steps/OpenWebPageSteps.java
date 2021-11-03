package cucumberTest.steps;

import driver.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.net.MalformedURLException;

public class OpenWebPageSteps {
    Driver driver = new Driver();


    @Given("I open the {string} web page and the title is {string}")
    public void openWebPageVerifyTitle(String pageUrl, String expectedTitle) throws MalformedURLException {
        driver.getDriver().get(pageUrl);
        Assert.assertEquals("Incorrect page title!", expectedTitle, driver.getDriver().getTitle());
        driver.getDriver().quit();
    }
}