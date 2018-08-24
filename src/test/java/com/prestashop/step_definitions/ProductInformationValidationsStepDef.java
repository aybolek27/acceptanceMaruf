package com.prestashop.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
/*
 *     // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
 
 */
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;

import cucumber.api.java.en.Then;

public class ProductInformationValidationsStepDef {

	HomePage homePage = new HomePage();

	ItemPage itemPage = new ItemPage();

	@Then("the user should be to see {string}")
	public void the_user_should_be_to_see(String productName) {

		assertTrue(homePage.item(productName).isDisplayed());

	}

	@Then("the user should be to see following products")
	public void the_user_should_be_to_see_following_products(List<String> products) {

		System.out.println(products.size());

		for (String product : products) {
			System.out.println(product);
			assertTrue(homePage.item(product).isDisplayed());

		}
	}

	@Then("the product should be available in the follwing sizes:")
	public void the_product_should_be_available_in_the_follwing_sizes(List<String> sizes) {

		System.out.println("number of sizes:" + sizes.size());
		for (String expected : sizes) {
			System.out.println(expected);
		}
		Select sizeSelect = itemPage.size();
		List<String> actualList = new ArrayList<>();
		for (WebElement optionElement : sizeSelect.getOptions()) {
			actualList.add(optionElement.getText());
		}

		// assertTrue(sizes.equals(actualList));
		//

		assertEquals(sizes, actualList);
	}

	@Then("the system should display the product information:")
	public void the_system_should_display_the_product_information(Map<String, String> product) {
		System.out.println(product);

		String expectedName = product.get("name");
		System.out.println("Product name: " + expectedName);
		assertEquals(expectedName, itemPage.itemName.getText());

		String expectedPrice = product.get("price");
		System.out.println("Product price: " + expectedPrice);
		assertEquals(expectedPrice, itemPage.price.getText());

		String expectedSize = product.get("size");
		System.out.println("Product size: " + expectedSize);
		assertEquals(expectedSize, itemPage.size().getFirstSelectedOption().getText());

		String expectedCondition = product.get("condition");
		System.out.println("Product condition: " + expectedCondition);
		assertEquals(expectedCondition, itemPage.condition.getText());

		String expectedCount = product.get("count");
		System.out.println("Product count: " + expectedCount);
		assertEquals(expectedCount, itemPage.count.getAttribute("value"));

	}

	@Then("the price should be {string}")
	public void the_price_should_be(String expectedPrice) {
		String actualPrice = new ItemPage().price.getText();
		assertEquals(expectedPrice, actualPrice);

	}

}
