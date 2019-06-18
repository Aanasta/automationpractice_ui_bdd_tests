package com.automationpractice.steps;

import com.automationpractice.steps.AbstractSteps;
import com.automationpractice.utils.ParsePomManager;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static com.automationpractice.pages.AccountPage.getAccountPageUrl;

public class LoggingInSteps extends AbstractSteps {

    @Step
    public void loginPageIsOpened() {
        loginPage.open();
    }

    @Step
    public void registeredUserLogsIntoAccount(String email, String password) {
        loginPage.loginToProfile(email, password);
    }

    @Step
    public void userFillsRequiredFieldsAndClicksRegister(String firstName, String lastName, String password, String address, String city, String state, String postalCode, String country, String phoneNumber) {
        loginPage.registerEmail();
        loginPage.fillPersonalData(firstName, lastName, password);
        loginPage.fillAddressData(address, city, state, postalCode, country, phoneNumber);
        loginPage.registerNewUser();
    }

    @Step
    public void userShouldBeRegistered() {
        Assert.assertEquals("Registered user is not logged in", ParsePomManager.getStringPropertyFromPom("newUserName"), accountPage.getLoggedInUsername());
    }

    @Step
    public void logoutButtonShouldBeClickable() {
        Assert.assertTrue("Logout button is not displayed", accountPage.isLogoutButtonDisplayed());
    }

    @Step
    public void userShouldBeLoggedIn() {
        Assert.assertEquals("Expected user is not logged in", ParsePomManager.getStringPropertyFromPom("validUserName"), accountPage.getLoggedInUsername());
    }

    @Step
    public void accountPageShouldBeOpened() {
        Assert.assertEquals("Account page isn't opened", getAccountPageUrl(), accountPage.getCurrentUrl());
    }

}
