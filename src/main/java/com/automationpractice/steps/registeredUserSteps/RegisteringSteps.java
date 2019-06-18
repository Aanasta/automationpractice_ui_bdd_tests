package com.automationpractice.steps.registeredUserSteps;

import com.automationpractice.steps.AbstractSteps;
import com.automationpractice.utils.ParsePomManager;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class RegisteringSteps extends AbstractSteps {

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

}
