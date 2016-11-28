package com.packtpub.mastering.selenium.steps;


import com.packtpub.mastering.selenium.pageobjects.Google;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.packtpub.mastering.selenium.pageobjects.Google;
import com.packtpub.mastering.selenium.pageobjects.LengthConverterPage;
import com.packtpub.mastering.selenium.pageobjects.TemperatureConverterPage;

import static org.junit.Assert.assertEquals;


/**
 * Created by talr on 28/11/2016.
 */
public class ConverterDropDownDefs {
    private WebDriver driver;
    public Google googlePage;
    public LengthConverterPage lengthConverterPage;
    private DriverSettings driverSettings ;
    private String activeChromeWebDriverPath = "";
    public TemperatureConverterPage temperatureConverterPage;

    @Given("^I open the converter web page$")
    public void I_open_the_converter_web_page() throws Throwable {
        driverSettings = new DriverSettings();
        driverSettings.setDriverProperties("Chrome");
        this.driver = driverSettings.prepareWebDriver("Chrome");

        googlePage = new Google(driver);
        temperatureConverterPage = googlePage.goToTemperatureConversionPage();
    }

    @When("^In the drop down I choose ([A-z ]+$)$")
    public void In_the_drop_down_I_choose_Speed(String arg1) throws Throwable  {
        temperatureConverterPage.goToUsingDropDown(arg1);

    }

    @Then("^the first selected messurement should be ([A-z ]+$)$")
    public void the_first_selected_messurement_should_be (String arg1) throws Throwable {
      assertEquals(arg1, temperatureConverterPage.getSelectedSubDropDown());
        driver.quit();
        
    }

}
