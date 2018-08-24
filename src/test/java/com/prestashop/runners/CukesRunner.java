package com.prestashop.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", 
				"html:target/default-cucumber-reports", 
				"json:target/cucumber.json"
		
}, 
		tags = "@temp", 
		features = "src/test/resources/com/prestashop/features", 
		glue = "com/prestashop/step_definitions", 
		dryRun = false
		
		
		)

public class CukesRunner {
}
//
// plugin={
// "json:target/cucumber.json",
// "html:target/cucumber/",
// "rerun:target/rerun.txt"
// }
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features="@target/rerun.txt",
//		plugin={
//				"json:target/cucumber.json",
//				 "html:target/cucumber/",
//				 "rerun:target/rerun.txt"
//
//}
//
//public class FailedScenarios{}