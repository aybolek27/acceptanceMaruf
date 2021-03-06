package com.prestashop.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	//will run before every single scenario
	@Before
	public void setup() {
		System.out.println("before scenario");
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		
	}
	
	@Before("@amazon_check")
	public void setupAmazon() {
		System.out.println("before scenario");
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get("http://amazon.com");
		
	}
	
	
	@After
	public void tearDown(Scenario scenario) {
		//only takes screenshot if the scenario fails
		if(scenario.isFailed()) {
			//taking a screenshot
			final byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			//adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}
	
}
