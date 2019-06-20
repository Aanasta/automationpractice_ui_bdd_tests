package com.automationpractice.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//p[contains(@class,'cart_navigation')]//span")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(id = "cgv")
    private WebElementFacade agreeToTermsCheckbox;

    @FindBy(className = "bankwire")
    private WebElementFacade bankwirePaymentButton;

    @FindBy(xpath = "//p[@id='cart_navigation']//button")
    private WebElementFacade confirmOrderButton;

    @FindBy(xpath = "//p[@class='cheque-indent']/strong")
    private WebElementFacade orderConfirmationMessage;

    @FindBy(xpath = "//span[@class='price']/strong")
    private WebElementFacade orderAmount;

    @FindBy(xpath = "//a[@title='Back to orders']")
    private WebElementFacade backToOrdersButton;

    @FindBy(xpath = "//span[@class='ajax_cart_quantity unvisible']")
    private WebElementFacade productsInCartCounter;

    @FindBy(name = "quantity_2_7_0_0")
    private WebElementFacade blouseQuantityInput;

    @FindBy(className = "icon-plus")
    private WebElementFacade plusQuantityButton;

    @FindBy(xpath = "//p/a[.='Blouse']")
    private WebElementFacade blouseInCartTitle;

    @FindBy(id = "total_product_price_2_7_0")
    private WebElementFacade totalPriceForBlouse;

    @FindBy(xpath = "//p/a[.='Faded Short Sleeve T-shirts']")
    private WebElementFacade tshirtInCartTitle;

    @FindBy(id = "total_product_price_1_1_0")
    private WebElementFacade totalPriceForTshirt;

    @FindBy(id = "total_price")
    private WebElementFacade totalPriceForCart;

    @FindBy(xpath = "//a[@id='cart_quantity_down_1_1_0_0']//i")
    private WebElementFacade tshirtQuantityMinusButton;

    //Navigate between Shopping cart tabs to purchase selected products be logged in user.
    // Please notice the com.automationpractice.steps will be different for not logged in user
    public void completePurchaseByLoggedinUser() {
        clickProceedToCheckout(); //in the Summary tab
        clickProceedToCheckout(); //in the Address tab
        checkTermsCheckbox(); //in the Shipping tab
        clickProceedToCheckout(); //in the Shipping tab
        clickBankwirePaymentButton(); //in the Payment tab
        clickConfirmOrderButton(); //in the Payment tab
    }

    public String getOrderConfirmationMessage() {
        return orderConfirmationMessage.getText();
    }

    public String getOrderAmount() {
        return orderAmount.getText();
    }

    public boolean isBackToOrdersButtonAvailable() {
        return backToOrdersButton.isEnabled();
    }

    public String getProductsInCartCount() {
        return productsInCartCounter.getAttribute("innerText");
    }

    public void setBlouseQuantityFromKeyboard(String newQuantity) {
        blouseQuantityInput.clear();
        blouseQuantityInput.sendKeys(newQuantity);
        blouseQuantityInput.waitUntilEnabled();
        blouseQuantityInput.click();
    }

    public String getBlousesQuantity() {
        return blouseQuantityInput.getAttribute("value");
    }

    public boolean isBlouseAddedToTheCart() {
        return blouseInCartTitle.isDisplayed();
    }

    public String getTotalPriceForBlouse() {
        return totalPriceForBlouse.getText();
    }

    public boolean isTshirtAddedToTheCart() {
        try {
            return tshirtInCartTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTotalPriceForTshirt() {
        return totalPriceForTshirt.getText();
    }

    public String getTotalPriceForCart() {
        return totalPriceForCart.getText();
    }

    public void setTshirtQuantityByMinusButton() {
        tshirtQuantityMinusButton.click();
        tshirtQuantityMinusButton.waitUntilNotVisible();
    }

    private void clickProceedToCheckout() {
        proceedToCheckoutButton.waitUntilClickable();
        proceedToCheckoutButton.click();
    }

    private void checkTermsCheckbox() {
        agreeToTermsCheckbox.isEnabled();
        agreeToTermsCheckbox.click();
    }

    private void clickBankwirePaymentButton() {
        bankwirePaymentButton.click();
    }

    private void clickConfirmOrderButton() {
        confirmOrderButton.click();
    }

}
