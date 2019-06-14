package tests.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import utils.ParsePomManager;

import static com.automationpractice.pages.AccountPage.getAccountPageUrl;

public class AccountPageSteps extends AbstractPageSteps {

    @Step
    public void accountPageShouldBeOpened() {
        Assert.assertEquals("Account page isn't opened", getAccountPageUrl(), accountPage.getCurrentUrl());
    }

    @Step
    public void userShouldBeLoggedIn() {
        Assert.assertEquals("Expected user is not logged in", ParsePomManager.getStringPropertyFromPom("validUserName"), accountPage.getLoggedInUsername());
    }

    @Step
    public void logoutButtonShouldBeClickable() {
        Assert.assertTrue("Logout button is not displayed", accountPage.isLogoutButtonDisplayed());
    }

    @Step
    public void userShouldBeRegistered() {
        Assert.assertEquals("Registered user is not logged in", ParsePomManager.getStringPropertyFromPom("newUserName"), accountPage.getLoggedInUsername());
    }

}
