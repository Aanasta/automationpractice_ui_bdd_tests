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
    // Please notice the steps will be different for not logged in user
    public void completePurchaseByLoggedinUser() {
        clickProceedToCheckout(); //in the Summary tab
        clickProceedToCheckout(); //in the Address tab
        checkTermsCheckbox(); //in the Shipping tab
        clickProceedToCheckout(); //in the Shipping tab
        clickBankwirePaymentButton(); //in the Payment tab
        clickConfirmOrderButton(); //in the Payment tab
    }

    public String getOrderConfirmationMessage() {
        return this.orderConfirmationMessage.getText();
    }

    public String getOrderAmount() {
        return this.orderAmount.getText();
    }

    public boolean isBackToOrdersButtonAvailable() {
        return this.backToOrdersButton.isEnabled();
    }

    public String getProductsInCartCount() {
        return this.productsInCartCounter.getAttribute("innerText");
    }

    public void setBlouseQuantityFromKeyboard(String newQuantity) {
        this.blouseQuantityInput.clear();
//        String editedQuantityForBlouse = getDataFromCell(getStringPropertyFromPom("excelPricelistPath"), cellAddress);
        this.blouseQuantityInput.sendKeys(newQuantity);
    }

    public String getBlousesQuantity() {
        return this.blouseQuantityInput.getAttribute("value");
    }

    public boolean isBlouseAddedToTheCart() {
        return this.blouseInCartTitle.isDisplayed();
    }

    public String getTotalPriceForBlouse() {
        return this.totalPriceForBlouse.getText();
    }

    public boolean isTshirtAddedToTheCart() {
        try {
            return this.tshirtInCartTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTotalPriceForTshirt() {
        return this.totalPriceForTshirt.getText();
    }

    public String getTotalPriceForCart() {
        return this.totalPriceForCart.getText();
    }

    public void setTshirtQuantityByMinusButton() {
        this.tshirtQuantityMinusButton.click();
//        this.tshirtQuantityMinusButton.waitUntil;
    }

    private void clickProceedToCheckout() {
        this.proceedToCheckoutButton.waitUntilClickable();
        proceedToCheckoutButton.click();
    }

    private void checkTermsCheckbox() {
        this.agreeToTermsCheckbox.click();
    }

    private void clickBankwirePaymentButton() {
        this.bankwirePaymentButton.click();
    }

    private void clickConfirmOrderButton() {
        this.confirmOrderButton.click();
    }

}
