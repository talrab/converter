package com.packtpub.mastering.selenium;


import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
//import cucumber.junit.Cucumber;

import cucumber.api.junit.Cucumber;

/**
 * Created by talr on 15/11/2016.
 */
@RunWith(Cucumber.class)
//@Cucumber.Options(format = {"pretty", "html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json","junit:target/cucumber-results.xml"})
//@CucumberOptions(format = {"pretty", "html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json","junit:target/cucumber-results.xml"})
//(working)// @CucumberOptions(format = "pretty","html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json","junit:target/cucumber-results.xml")
@CucumberOptions( plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json" })




public class RunCukesTest {
}
