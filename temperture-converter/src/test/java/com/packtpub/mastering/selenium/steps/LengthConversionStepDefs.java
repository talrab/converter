package com.packtpub.mastering.selenium.steps;

import com.packtpub.mastering.selenium.pageobjects.Google;
import com.packtpub.mastering.selenium.pageobjects.LengthConverterPage;
import com.packtpub.mastering.selenium.pageobjects.TemperatureConverterPage;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Ripon on 11/26/2015.
 */
public class LengthConversionStepDefs {
    private WebDriver driver;
    public Google googlePage;
    public LengthConverterPage lengthConverterPage;
    private DriverSettings driverSettings ;
    private String activeChromeWebDriverPath = "";

    @Given("^I want to convert (\\d+) Meter to Feet$")
    public void I_want_to_convert_Meter_to_Feet(int arg1) throws Throwable {

        driverSettings = new DriverSettings();
        activeChromeWebDriverPath = driverSettings.getActiveChromeWebDriverPath();
        System.setProperty("webdriver.chrome.driver", activeChromeWebDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        googlePage = new Google(driver);
        lengthConverterPage = googlePage.goToLengthConversionPage();
    }

    @When("^I input the value of Meter (\\d+) in text field$")
    public void I_input_the_value_of_Meter_in_text_field(int arg1) throws Throwable {
        //input Meter value
        lengthConverterPage.inputMeter(arg1);
    }

    @Then("^It should be converted to Feet as (\\d+.\\d+)$")
    public void It_should_be_converted_to_Feet_as_(double arg1) throws Throwable {
        //assertion
        assertEquals(lengthConverterPage.actualResult(), lengthConverterPage.expectedResult(arg1));
        driver.quit();
    }
}