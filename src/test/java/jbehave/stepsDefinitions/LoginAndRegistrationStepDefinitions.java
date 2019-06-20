package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import static com.automationpractice.pages.AccountPage.getAccountPageUrl;

public class LoginAndRegistrationStepDefinitions extends AbstractStepDefinitions {

    @Given("login page is opened")
    public void loginPageIsOpened() {
        loginPage.open();
    }

    @When("registered user logs into account with <email> and <password>")
    @Given("registered user logs into account with <email> and <password>")
    public void registeredUserLogsIntoAccount(@Named("email") String email, @Named("password") String password) {
        loginPage.loginToProfile(email, password);
    }

    @When("user fills email field with his email")
    public void userFillsRegistrationEmail() {
        loginPage.registerEmail();
    }

    @When("user fills personal data fields with his <firstName>, <lastName>, and <password>")
    public void userFillsRegistrationPersonalData(@Named("firstName") String firstName, @Named("lastName") String lastName, @Named("password") String password) {
        loginPage.fillPersonalData(firstName, lastName, password);
    }

    @When("user fills address fields with his <address>, <city>, <state>, <postalCode>, <country>, <phoneNumber>")
    public void userFillsRegistrationAddressData(@Named("address") String address, @Named("city") String city, @Named("state") String state, @Named("postalCode") String postalCode, @Named("country") String country, @Named("phoneNumber") String phoneNumber) {
        loginPage.fillAddressData(address, city, state, postalCode, country, phoneNumber);
    }

    @When("user clicks Register button")
    public void userClicksRegister() {
        loginPage.registerNewUser();
    }

    @Then("user's account page should be opened")
    public void accountPageShouldBeOpened() {
        Assert.assertEquals("Account page isn't opened", getAccountPageUrl(), accountPage.getCurrentUrl());
    }

    @Then("user should be logged in as <username>")
    public void userShouldBeLoggedIn(@Named("username") String username) {
        Assert.assertEquals("Expected user is not logged in", username, accountPage.getLoggedInUsername());
    }

    @Then("user should be able to logout")
    public void logoutButtonShouldBeClickable() {
        Assert.assertTrue("Logout button is not displayed", accountPage.isLogoutButtonDisplayed());
    }

}
