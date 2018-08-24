package com.prestashop.step_definitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.pages.SigninPage;
import com.prestashop.utilities.BrowserUtils;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs {
	SigninPage signinPage = new SigninPage();
	String email;

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		// open website
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		// go to login page
		new HomePage().signin.click();
	}

	@When("I login using username {string} and password {string}")
	public void i_login_using_username_and_password(String username, String password) {

		signinPage.loginEmail.sendKeys(username);
		signinPage.password.sendKeys(password);
		// submit()---> submits the current method (this is from selenium)
		signinPage.submitLogin.click();

	}

	@Then("users full name {string} {string} should be displayed")
	public void users_full_name_should_be_displayed(String firstName, String lastName) {
		String expected = firstName + " " + lastName;
		String actual = new MyAccountPage().fullname.getText();
		assertEquals(expected, actual);

	}

	@When("the user tries to register an invalid email")
	public void the_user_tries_to_register_an_invalid_email() {
		signinPage.signupEmail.sendKeys("uygurkidno1gmial.com");
		signinPage.signupEmail.submit();

	}

	@Then("the system shoul display error message {string}")
	public void the_system_shoul_display_error_message(String message) {

		// signinPage.errorMessage is always present in the page, with or without any
		// error
		// but it only becomes visible when there is an actual error message
		// calling an explicit wait utility method to wait for the visibility of the
		// message

		BrowserUtils.waitForVisibility(signinPage.errorMessage, 5);
		// now that element is fully loaded, we can capture the text

		String actual = signinPage.errorMessage.getText();
		assertEquals(message, actual);
	}

	@When("the user tries to register blank email")
	public void the_user_tries_to_register_blank_email() {
		// submit the form without entering email
		signinPage.signupEmail.sendKeys("");
		signinPage.signupEmail.submit();
	}

	@Given("there is an existing user")
	public void there_is_an_existing_user() {
		// generate new email
		Faker fake = new Faker();
		new HomePage().signin.click();
		
		email = fake.name().username() + "@gmail.com";
		signinPage.signupEmail.sendKeys(email + Keys.ENTER);
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.firstName.sendKeys(fake.name().firstName());
		registrationPage.lastName.sendKeys(fake.name().lastName());
		registrationPage.password.sendKeys("password123");

		Address address = fake.address();
		registrationPage.address.sendKeys(address.buildingNumber() + " " + address.streetName());
		registrationPage.city.sendKeys(address.city());
		BrowserUtils.waitFor(2);
		
		Select stateList=registrationPage.stateList();
		stateList.selectByValue("2");
		
		
		
		
		registrationPage.stateList().selectByIndex(2);

//		Select states = registrationPage.stateList();
//
//		for (WebElement option : states.getOptions()) {
//			
//		}
//		
		
		registrationPage.zipCode.sendKeys("77099");
		registrationPage.mobilePhone.sendKeys(fake.phoneNumber().cellPhone());
		registrationPage.registerButton.click();
		
		MyAccountPage myAccountPage=new MyAccountPage();
		myAccountPage.logout.click();
		
		
		// click register
		// enter first name, last name, password, address....
		// finalize registration

	}

	@When("the user tries to register the same email")
	public void the_user_tries_to_register_the_same_email() {
		signinPage.signupEmail.sendKeys(email+Keys.ENTER);
		
		
	}

}
