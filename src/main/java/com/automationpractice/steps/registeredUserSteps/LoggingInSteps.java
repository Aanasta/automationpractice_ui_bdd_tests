package com.automationpractice.steps.registeredUserSteps;

import com.automationpractice.steps.AbstractSteps;
import com.automationpractice.utils.ParsePomManager;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoggingInSteps extends AbstractSteps {

    @Step
    public void registeredUserLogsIntoAccount(String email, String password) {
        loginPage.loginToProfile(email, password);
    }

    @Step
    public void userShouldBeLoggedIn() {
        Assert.assertEquals("Expected user is not logged in", ParsePomManager.getStringPropertyFromPom("validUserName"), accountPage.getLoggedInUsername());
    }

}
