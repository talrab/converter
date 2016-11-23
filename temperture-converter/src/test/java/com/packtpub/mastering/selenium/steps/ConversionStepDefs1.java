package com.packtpub.mastering.selenium.steps;

import com.packtpub.mastering.selenium.pageobjects.Google;
import com.packtpub.mastering.selenium.pageobjects.TemperatureConverterPage;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ripon on 11/26/2015.
 */
public class ConversionStepDefs1 {
    private WebDriver driver;
    public Google googlePage;
    public TemperatureConverterPage temperatureConverterPage;
    private String chromeWebDriverpath1 = "c:\\D\\Online Courses\\Selenium and continoues integration\\Tools\\chromedriver.exe";
    private String chromeWebDriverpath2 = "d:\\Tal - Work Related\\myWorkspace\\chromedriver.exe";
    private String activeChromeWebDriverPath = "";
    @Given("I need to  convert (\\d+).(\\d+) degree Fahrenheit to Celsius")
    public void I_want_to_convert_degree_Fahrenheit_to_Celsius(int arg1, int arg2) throws Throwable {

        File f = new File (chromeWebDriverpath1);
        if (f.exists()) {
            activeChromeWebDriverPath = chromeWebDriverpath1;
        }
        else{
            activeChromeWebDriverPath = chromeWebDriverpath2;
        }

        System.setProperty("webdriver.chrome.driver", activeChromeWebDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        googlePage = new Google(driver);
        temperatureConverterPage = googlePage.goToTemperatureConversionPage();
    }

    @When("^I then input the value of Fahrenheit as (\\d+) in text field$")
    public void I_input_the_value_of_Fahrenheit_as_in_text_field(int arg1) throws Throwable {
        //input Fahrenheit value
        System.out.println("arg1 = " + arg1);
        temperatureConverterPage.inputFahrenheit(arg1);
        //test comment1b
    }

    @Then("^It then should be converted to Celsius as (\\d+) degree$")
    public void It_should_be_converted_to_Celsius_as_degree(int arg1) throws Throwable {
        //assertion
        assertEquals(temperatureConverterPage.actualResult(), temperatureConverterPage.expectedResult(arg1));
        driver.quit();
    }
}