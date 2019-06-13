package com.automationpractice.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitManager;

import java.util.List;

public class AbstractPage extends PageObject {

    @FindBy(xpath = "//img[@alt='My Store']")
    private WebElementFacade mainLogo;

    @FindBy(xpath = "//div[@class='product-container']")
    private WebElementFacade productContainer;

    private static final String PRODUCT_CONTAINER_XPATH = "//div[@class='product-container']";

    public WebElement getMainLogo() {
        return mainLogo;
    }

    public String getCurrentUrl() {
        return  getDriver().getCurrentUrl();
    }

    public boolean isProductContainerDisplayed() {
        return this.productContainer.isDisplayed();
    }

    public int getDisplayedProductsCount() {
        List<WebElement> productContainers = getDriver().findElements(By.xpath(PRODUCT_CONTAINER_XPATH));
        return productContainers.size();
    }

    public void clickLogoAndOpenMainPage() {
//        getWaiter().waitForElementToBeClickable(this.mainLogo);
        this.mainLogo.waitUntilVisible();
        this.mainLogo.click();
    }

    WaitManager getWaiter() {
        return new WaitManager();
    }


}
