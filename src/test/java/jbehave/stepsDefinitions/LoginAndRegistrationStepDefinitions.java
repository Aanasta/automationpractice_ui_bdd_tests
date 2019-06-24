package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.*;

public class LoginAndRegistrationStepDefinitions extends AbstractStepDefinitions {

    @Given("login page is opened")
    public void loginPageIsOpened() {
        loggingInSteps.loginPageIsOpenedStep();
    }

    @When("registered user logs into account with <email> and <password>")
    @Given("registered user logs into account with <email> and <password>")
    public void registeredUserLogsIntoAccount(@Named("email") String email, @Named("password") String password) {
        loggingInSteps.registeredUserLogsIntoAccountStep(email, password);
    }

    @When("user fills email field with his email")
    public void userFillsRegistrationEmail() {
        loggingInSteps.userRegisterEmailStep();
    }

    @When("user fills personal data fields with his <firstName>, <lastName>, and <password>")
    public void userFillsRegistrationPersonalData(@Named("firstName") String firstName, @Named("lastName") String lastName, @Named("password") String password) {
        loggingInSteps.userFillsPersonalDataStep(firstName, lastName, password);
    }

    @When("user fills address fields with his <address>, <city>, <state>, <postalCode>, <country>, <phoneNumber>")
    public void userFillsRegistrationAddressData(@Named("address") String address, @Named("city") String city, @Named("state") String state, @Named("postalCode") String postalCode, @Named("country") String country, @Named("phoneNumber") String phoneNumber) {
        loggingInSteps.userFillsAddressDataStep(address, city, state, postalCode, country, phoneNumber);
    }

    @When("user clicks Register button")
    public void userClicksRegister() {
        loggingInSteps.registerNewUserStep();
    }

    @Then("user's account page should be opened")
    public void accountPageShouldBeOpened() {
        loggingInSteps.isAccountPageOpenedStep();
    }

    @Then("user should be logged in as <username>")
    public void userShouldBeLoggedIn(@Named("username") String username) {
        loggingInSteps.isUserLoggedInStep(username);
    }

    @Then("user should be able to logout")
    public void logoutButtonShouldBeClickable() {
        loggingInSteps.isLogoutButtonClickableStep();
    }

}
