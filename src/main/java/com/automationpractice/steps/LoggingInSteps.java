package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static com.automationpractice.pages.AccountPage.getAccountPageUrl;

public class LoggingInSteps extends AbstractSteps {

    @Step
    public void loginPageIsOpenedStep() {
        loginPage.open();
    }

    @Step
    public void registeredUserLogsIntoAccountStep(String email, String password) {
        loginPage.loginToProfile(email, password);
    }

    @Step
    public void registerNewUserStep() {
        loginPage.registerNewUser();
    }

    @Step
    public void userRegisterEmailStep() {
        loginPage.registerEmail();
    }

    @Step
    public void userFillsPersonalDataStep(String firstName, String lastName, String password) {
        loginPage.fillPersonalData(firstName, lastName, password);
    }

    @Step
    public void userFillsAddressDataStep(String address, String city, String state, String postalCode, String country, String phoneNumber) {
        loginPage.fillAddressData(address, city, state, postalCode, country, phoneNumber);
    }

    @Step
    public void isLogoutButtonClickableStep() {
        Assert.assertTrue("Logout button is not displayed", accountPage.isLogoutButtonDisplayed());
    }

    @Step
    public void isUserLoggedInStep(String validUserName) {
        Assert.assertEquals("Expected user is not logged in", validUserName, accountPage.getLoggedInUsername());
    }

    @Step
    public void isAccountPageOpenedStep() {
        Assert.assertEquals("Account page isn't opened", getAccountPageUrl(), accountPage.getCurrentUrl());
    }

}
