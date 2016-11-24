package com.packtpub.mastering.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ripon on 11/28/2015.
 */
public class LengthConverterPage {
    private WebDriver driver;
    public LengthConverterPage(WebDriver driver){
        this.driver = driver;
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("from meter to feet - Google Search")){
            throw new WrongPageException("Incorrect page for Length Conversion page");
        }
    }
    public void inputMeter(int valueOfMeter){
        String s = Integer.toString(valueOfMeter);
        driver.findElement(By.xpath(".//*[@id='_Aif']/input")).clear();
        driver.findElement(By.xpath(".//*[@id='_Aif']/input")).sendKeys(s);
    }
    public String actualResult(){
        String valueOfFeet = driver.findElement(By.xpath(".//*[@id='_Cif']/input")).getAttribute("value");
        System.out.println(valueOfFeet);
        return valueOfFeet;
    }
    public String expectedResult(double result){
        return String.valueOf(result);
    }
}
