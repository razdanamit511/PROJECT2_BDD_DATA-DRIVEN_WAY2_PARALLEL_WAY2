package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.ForgotPassword_Page;
import utils.XLUtils;

public class ForgotPassword_StepDefinitions {

	ForgotPassword_Page forgotpasswordpage = new ForgotPassword_Page(DriverFactory.getDriver());


	@Then("Forgot Password label is displayed")
	public void user_get_label() {
		Assert.assertTrue(forgotpasswordpage.isForgotPasswordLabelPresent());
	}

	@Then("Please enter your email address below to receive a password reset link. label is displayed")
	public void user_get_label_message() {
		Assert.assertTrue(forgotpasswordpage.isMessageLabelPresent());
	}

	@Then("Email label")
	public void email_label() {
		Assert.assertTrue(forgotpasswordpage.isEmailLabelPresent());
	}

	@Then("Reset My Password button")
	public void reset_my_password_button() {
		Assert.assertTrue(forgotpasswordpage.isResetMyPasswordButtonPresent());
	}

	@Then("{string} is displayed under Email textbox")
	public void user_gets_error_email(String string) {
		Assert.assertEquals(forgotpasswordpage.getEmailMandatoryMessage(), string);
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String string) {
		forgotpasswordpage.ClickResetMyPasswordButton();
	}

	@Then("Email label is displayed")
	public void Email_label_is_displayed() {
		Assert.assertTrue(forgotpasswordpage.isEmailLabelPresent());
	}

	@Then("Email textbox is displayed")
	public void Email_textbox_is_displayed() {
		Assert.assertTrue(forgotpasswordpage.isEmailTextboxPresent());
	}

	@Then("Reset My Password button is displayed")
	public void Reset_My_Password_button_is_displayed() {
		Assert.assertTrue(forgotpasswordpage.isResetMyPasswordButtonPresent());
	}

	@When("User enters credentails from {string}, {string} and {string} in forgot password form")
	public void user_enters_data_from_and_in_forgot_password_form(String string, String string2, String string3)
			throws Exception {

		Integer row = Integer.valueOf(string3);

		List<Map<String, String>> allData = XLUtils.getAllSheetData("src\\test\\resources\\testdata\\TestData2.xlsx",
				string2);

		Map<String, String> FormData = allData.get(row);

		forgotpasswordpage.EnterEmail(FormData.get("Email"));

	}

	@Then("User gets error message as {string}")
	public void user_gets_error_message_as(String string) {
		Assert.assertEquals(forgotpasswordpage.getEmailMandatoryMessage(), string);
	}

	@Then("User gets success message as {string}")
	public void user_gets_success_message_as(String string) {
		Assert.assertEquals(forgotpasswordpage.getResetSuccessMessage(), string);
	}

}
