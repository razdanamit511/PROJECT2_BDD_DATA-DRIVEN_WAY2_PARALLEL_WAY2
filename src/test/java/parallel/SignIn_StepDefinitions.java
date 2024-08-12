package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.Home_Page;
import pages.SignIn_Page;
import utils.XLUtils;

public class SignIn_StepDefinitions {

	SignIn_Page spage = new SignIn_Page(DriverFactory.getDriver());
	Home_Page hpage = new Home_Page(DriverFactory.getDriver());

	String title = null;

	@Then("Email label is displayed on sign-in page")
	public void email_label_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isEmailLabelPresent());
	}

	@Then("Email textbox is displayed on sign-in page")
	public void email_textbox_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isEmailTextboxPresent());
	}

	@Then("Password label is displayed on sign-in page")
	public void password_label_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isPasswordLabelPresent());
	}

	@Then("Password textbox is displayed on sign-in page")
	public void password_textbox_is_displayed_on_sign_in_page() {
		Assert.assertTrue(spage.isPasswordTextboxPresent());
	}

	@Then("Forgot Password Link is displayed")
	public void forgot_password_link_is_displayed() {
		Assert.assertTrue(spage.isForgotPasswordLinkPresent());
	}

	@Then("Create An Account button is displayed")
	public void create_an_account_button_is_displayed() {
		Assert.assertTrue(spage.isCreateAnAccountButtonPresent());
	}

	@Then("Sign-In button is displayed")
	public void sign_in_button_is_displayed() {
		Assert.assertTrue(spage.isSignInButtonPresent());
	}

	@When("User enters valid credentials in sign-in form")
	public void user_enters_valid_in_email_textbox(DataTable signincreds) throws InterruptedException {

		// Write the code to handle Data Table
		List<List<String>> data = signincreds.asLists(String.class);

		for (List<String> list : data) {
			System.out.println("User enters " + list.get(0) + " in username textbox");
			System.out.println("User enters " + list.get(1) + " in password textbox");

			System.out.println("Username " + list.get(0));

			spage.EnterEmail(list.get(0));

			System.out.println("Password " + list.get(1));

			spage.EnterPassword(list.get(1));

			Thread.sleep(3000);

			spage.ClickSignInButton();

			Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Home Page");

			Thread.sleep(5000);

			hpage.ClickSettingsDropdown();

			Thread.sleep(5000);

			hpage.ClickSignoutButton();

			Thread.sleep(5000);

			spage.OpenSignInPage();

		}

	}

	@When("User enters invalid credentials in sign-in form")
	public void user_enters_invalid_in_email_textbox(DataTable signincreds) throws InterruptedException {

		// Write the code to handle Data Table
		// List<Map<String,String>> data = signincreds.asMaps(String.class,
		// String.class);

		for (Map<String, String> mapData : signincreds.asMaps(String.class, String.class)) {

			System.out.println("Username " + mapData.get("username"));

			spage.EnterEmail(mapData.get("username"));

			System.out.println("Password " + mapData.get("password"));

			spage.EnterPassword(mapData.get("password"));

			Thread.sleep(3000);

			spage.ClickSignInButton();

			Thread.sleep(3000);

			Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Customer Login");

			Thread.sleep(5000);

			spage.ClearEmail();

			spage.ClearPassword();

		}

	}

	/*
	 * @When("User clicks Sign-In button") public void user_clicks_sign_in_button()
	 * { spage.ClickSignInButton(); }
	 */

	@When("User enters data from {string}, {string} and {string} in sign-in form")
	public void user_enters_data_from_and_in_sign_in_form(String string, String string2, String string3)
			throws Exception {

		Integer row = Integer.valueOf(string3);

		List<Map<String, String>> allData = XLUtils.getAllSheetData(
				"E:\\LEARNING\\SOFTWARE TESTING\\02- TRAINING\\04- AUTOMATED TESTING\\04- HOW TO PERFORM\\02- CODE BASED AUTOMATION\\02 - AUTOMATION TYPES\\1- WEB AUTOMATION\\02 - FRAMEWORKS\\2- CUICUMBER Framework\\2- Tutoriuals\\12- HYBRID FRAMEWORK DESIGN\\TestData.xlsx",
				string2);

		Map<String, String> FormData = allData.get(row);

		spage.EnterEmail(FormData.get("Email"));
		spage.EnterPassword(FormData.get("Password"));

	}

	@When("User clicks Sign-In button")
	public void user_clicks_sign_in_button() {

		spage.ClickSignInButton();

	}

	@Then("User gets page title as {string}")
	public void user_gets_page_title_as(String string) {

	}

}
