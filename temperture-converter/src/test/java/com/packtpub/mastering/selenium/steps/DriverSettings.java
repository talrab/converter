package com.packtpub.mastering.selenium.steps;

import java.io.File;

/**
 * Created by talr on 24/11/2016.
 */
public class DriverSettings {
    private String chromeWebDriverpath1 = "c:\\D\\Online Courses\\Selenium and continoues integration\\Tools\\chromedriver.exe";
    private String chromeWebDriverpath2 = "d:\\Tal - Work Related\\myWorkspace\\chromedriver.exe";
    private String activeChromeWebDriverPath = "";

    public DriverSettings() {
                }


        public String getActiveChromeWebDriverPath () {

            File f = new File (chromeWebDriverpath1);
            if (f.exists()) {
                activeChromeWebDriverPath = chromeWebDriverpath1;
            }
            else{
                activeChromeWebDriverPath = chromeWebDriverpath2;
            }
            return activeChromeWebDriverPath;
        }

}
