package com.packtpub.mastering.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Ripon on 11/28/2015.
 */
public class TemperatureConverterPage {
    private WebDriver driver;
    public TemperatureConverterPage(WebDriver driver){
        this.driver = driver;
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("from fahrenheit to celsius - Google Search")){
            throw new WrongPageException("Incorrect page for Temperature Conversion page");
        }
    }
    public void inputFahrenheit(double valueOfFahrenheit){
        String s = Double.toString(valueOfFahrenheit);
        driver.findElement(By.xpath(".//*[@id='_Aif']/input")).clear();
        driver.findElement(By.xpath(".//*[@id='_Aif']/input")).sendKeys(s);
    }
    public String actualResult(){
        String valueOfCelsius = driver.findElement(By.xpath(".//*[@id='_Cif']/input")).getAttribute("value");
        System.out.println(valueOfCelsius);
        return valueOfCelsius;
    }
    public String expectedResult(int result){
        return String.valueOf(result);
    }


    public void goToUsingDropDown (String dropDownItem){
        //Select select = new Select(driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div[1]/select")));
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div[1]/select")));
        select.selectByValue(dropDownItem);
    }

    public String getSelectedSubDropDown () {
        Select subSelect = new Select(driver.findElement(By.xpath("//*[@id=\"_Bif\"]")));
        System.out.println(subSelect.getFirstSelectedOption().getText() + "#################################");
        return subSelect.getFirstSelectedOption().getText();
    }
}
