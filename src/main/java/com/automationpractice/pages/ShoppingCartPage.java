package com.automationpractice.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.ExcelManager.getDataFromCell;
import static utils.ParsePomManager.getStringPropertyFromPom;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//p[contains(@class,'cart_navigation')]//span")
    private WebElement proceedToCheckoutButton;

    @FindBy(id = "cgv")
    private WebElement agreeToTermsCheckbox;

    @FindBy(className = "bankwire")
    private WebElement bankwirePaymentButton;

    @FindBy(xpath = "//p[@id='cart_navigation']//button")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//p[@class='cheque-indent']/strong")
    private WebElement orderConfirmationMessage;

    @FindBy(xpath = "//span[@class='price']/strong")
    private WebElement orderAmount;

    @FindBy(xpath = "//a[@title='Back to orders']")
    private WebElement backToOrdersButton;

    @FindBy(xpath = "//span[@class='ajax_cart_quantity unvisible']")
    private WebElement productsInCartCounter;

    @FindBy(name = "quantity_2_7_0_0")
    private WebElement blouseQuantityInput;

    @FindBy(className = "icon-plus")
    private WebElement plusQuantityButton;

    @FindBy(xpath = "//p/a[.='Blouse']")
    private WebElement blouseInCartTitle;

    @FindBy(id = "total_product_price_2_7_0")
    private WebElement totalPriceForBlouse;

    @FindBy(xpath = "//p/a[.='Faded Short Sleeve T-shirts']")
    private WebElement tshirtInCartTitle;

    @FindBy(id = "total_product_price_1_1_0")
    private WebElement totalPriceForTshirt;

    @FindBy(id = "total_price")
    private WebElement totalPriceForCart;

    @FindBy(xpath = "//a[@id='cart_quantity_down_1_1_0_0']//i")
    private WebElement tshirtQuantityMinusButton;

    private static final String TSHIRT_QUANTITY_MINUS_BUTTON = "//a[@id='cart_quantity_down_1_1_0_0']//i";

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

    public void setBlouseQuantityFromKeyboard(String cellAddress) {
        this.blouseQuantityInput.clear();
        String editedQuantityForBlouse = getDataFromCell(getStringPropertyFromPom("excelPricelistPath"), cellAddress);
        this.blouseQuantityInput.sendKeys(editedQuantityForBlouse);
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
        getWaiter().waitForElementToDisappear(TSHIRT_QUANTITY_MINUS_BUTTON);
    }

    private void clickProceedToCheckout() {
//        proceedToCheckoutButton.wai;
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
