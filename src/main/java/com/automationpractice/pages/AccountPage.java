package com.automationpractice.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(className = "logout")
    private WebElementFacade logoutButton;

    @FindBy(xpath = "//a[@class='account']//span")
    private WebElementFacade loggedInUsername;

    private static final String ACCOUNT_PAGE_URL = "http://automationpractice.com/index.php?controller=my-account";

    public static String getAccountPageUrl() {
        return ACCOUNT_PAGE_URL;
    }

    public String getLoggedInUsername() {
        return loggedInUsername.getText();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isEnabled();
    }

}
