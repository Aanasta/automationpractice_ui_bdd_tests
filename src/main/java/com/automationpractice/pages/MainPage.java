package com.automationpractice.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://automationpractice.com")
public class MainPage extends AbstractPage {

    @FindBy(id = "search_query_top")
    private WebElementFacade searchBarInput;

    @FindBy(xpath = "//ul[@id='homefeatured']//div[@class='product-container']")
    private List<WebElementFacade> popularProducts;

    @FindBy(xpath = "//a[@title='My Store']")
    private WebElementFacade mainLogoLink;

    @FindBy(xpath = "//div[@class='shopping_cart']//b")
    private WebElementFacade shoppingCartButton;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElementFacade womenTabLabel;

    @FindBy(xpath = "//ul[@id='homefeatured']//img[@title='Faded Short Sleeve T-shirts']")
    private WebElementFacade tshirtContainer;

    @FindBy(xpath = "//ul[@id='homefeatured']//img[@title='Blouse']")
    private WebElementFacade blouseContainer;

    @FindBy(xpath = "//ul[@id='homefeatured']//a[@data-id-product='1']//span")
    private WebElementFacade addTshirtToCartButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElementFacade proceedToCheckoutPopupButton;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElementFacade continueShoppingPopupButton;

    @FindBy(xpath = "//ul[@id='homefeatured']//a[@data-id-product='2']//span")
    private WebElementFacade addBlouseToCartButton;

    public boolean isSearchBarAvailable() {
        return this.searchBarInput.isDisplayed();
    }

    public int getPopularProductsCount() {
        return this.popularProducts.size();
    }

    public boolean isMainLogoDisplayed() {
        return this.getMainLogo().isDisplayed();
    }

    public String getMainLogoUrl() {
        return this.mainLogoLink.getAttribute("href");
    }

    public boolean isShoppingCartButtonClickable() {
        return this.shoppingCartButton.isEnabled();
    }

    public void searchForProduct(String searchedProduct) {
        this.searchBarInput.sendKeys(searchedProduct);
        this.searchBarInput.sendKeys(Keys.ENTER);
    }

    public void openWomenTab() {
        this.womenTabLabel.click();
    }

    public void addTshirtAndGoToShoppingCart() {
        hoverTshirtProductContainer();
        clickAddTshirtToCartButton();
        clickProceedToCheckoutPopupButton();
    }
    private void hoverTshirtProductContainer() {
        this.tshirtContainer.waitUntilClickable();
        Actions builder = new Actions(getDriver());
        builder.moveToElement(tshirtContainer).build().perform();
    }

    private void clickAddTshirtToCartButton() {
        this.addTshirtToCartButton.waitUntilClickable();
        this.addTshirtToCartButton.click();
    }

    private void clickProceedToCheckoutPopupButton() {
        this.proceedToCheckoutPopupButton.isPresent();
        this.proceedToCheckoutPopupButton.click();
    }

    private void clickContinueShoppingPopupButton() {
        this.continueShoppingPopupButton.waitUntilClickable();
        this.continueShoppingPopupButton.click();
    }

    public void addBlouseAndContinueShopping() {
        hoverBlouseProductContainer();
        clickAddBlouseToCartButton();
        clickContinueShoppingPopupButton();
    }

    private void hoverBlouseProductContainer() {
        this.blouseContainer.waitUntilClickable();
        Actions builder = new Actions(getDriver());
        builder.moveToElement(blouseContainer).build().perform();
    }

    private void clickAddBlouseToCartButton() {
        this.addBlouseToCartButton.waitUntilClickable();
        this.addBlouseToCartButton.click();
    }

}
