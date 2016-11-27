package com.packtpub.mastering.selenium.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by talr on 24/11/2016.
 */
public class DriverSettings {
    private String chromeWebDriverpath1 = "c:\\D\\Online Courses\\Selenium and continoues integration\\Tools\\chromedriver.exe";
    private String chromeWebDriverpath2 = "d:\\Tal - Work Related\\myWorkspace\\chromedriver.exe";
    private String activeChromeWebDriverPath = "";
    private WebDriver driver = null;

    public DriverSettings() {
                }


        private String getActiveChromeWebDriverPath () {

            File f = new File (chromeWebDriverpath1);
            if (f.exists()) {
                activeChromeWebDriverPath = chromeWebDriverpath1;
            }
            else{
                activeChromeWebDriverPath = chromeWebDriverpath2;
            }
            return activeChromeWebDriverPath;
        }

        public void setDriverProperties (String driverType) {
            String path = getActiveChromeWebDriverPath();
            if (driverType == "Chrome") {
                System.setProperty("webdriver.chrome.driver", path);
            }
        }
        public WebDriver prepareWebDriver (String driverType){

            if (driverType == "Chrome") {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            return driver;
        }

}
