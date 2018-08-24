package com.prestashop.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.prestashop.pages.SearchResultsPage;
import com.prestashop.utilities.BrowserUtils;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.ExcelUtil;
import com.prestashop.utilities.TestConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepsDef {

	SearchResultsPage searchResultsPage = new SearchResultsPage();

	@Given("the user clicks on link Dresses")
	public void the_user_clicks_on_link_Dresses() {

		searchResultsPage.dresses.click();

	}

	@When("user sorts by {string}")
	public void user_sorts_by(String option) {

		searchResultsPage.sortBy().selectByVisibleText(option);
		BrowserUtils.waitFor(2);

	}

	@Then("following product should be displayed on top")
	public void following_product_should_be_displayed_on_top(Map<String, String> map) {
		Actions action = new Actions(Driver.getDriver());
		action.sendKeys(Keys.ARROW_DOWN).perform();

		String expectedName = map.get("name");
		String expectedPrice = map.get("price");

		String actualName = searchResultsPage.getProductName(1).getText();
		String actualPrice = searchResultsPage.getProductPrice(1).getText();

		assertEquals(expectedName, actualName);
		assertEquals(expectedPrice, actualPrice);

	}

	@Then("the user should be able to sort results")
	public void the_user_should_be_able_to_sort_results() {
		// open excel
		String fileLocation = TestConstants.TEST_DATA_FOLDER + "Maruf4.xlsx";
		ExcelUtil excelObject = new ExcelUtil(fileLocation, "Sheet2");
		// iterate through data
		List<Map<String, String>> data = excelObject.getDataList();
		
		boolean passing=true;
		for (int i = 0; i < data.size(); i++) {
			Map<String, String> row = data.get(i);
			// see if the execute that row
			if (row.get("Execute").equals("Y")) {
				// sort based on the excel sort value
				searchResultsPage.sortBy().selectByVisibleText(row.get("Option"));
				BrowserUtils.waitFor(1);
				Actions action = new Actions(Driver.getDriver());
				action.sendKeys(Keys.ARROW_DOWN).perform();

				// verify name and price based on value from excel
				String expectedName = row.get("Name");
				String expectedPrice = row.get("Price");

				String actualName = searchResultsPage.getProductName(1).getText();
				String actualPrice = searchResultsPage.getProductPrice(1).getText();

				if (expectedName.equals(actualName) && actualPrice.contains(expectedPrice)) {
					excelObject.setCellData("Passed", "Status", i + 1);

				} else {
					excelObject.setCellData("Failed", "Status", i + 1);
					passing=false;
				}
			} else {

				excelObject.setCellData("Skipped", "Status", i + 1);
			}

		}
		assertTrue(passing);

	}

}
