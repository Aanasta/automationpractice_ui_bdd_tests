package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OrderingProductsSteps extends AbstractSteps {

    @Step
    public void completeOrderInPurchaseWizardStep() {
        shoppingCartPage.completePurchaseByLoggedinUser();
    }

    @Step
    public void isOrderConfirmationDisplayedStep(String orderConfirmationMessage) {
        Assert.assertEquals("Order is not completed", orderConfirmationMessage, shoppingCartPage.getOrderConfirmationMessage());
    }

    @Step
    public void isOrderAmountAsSetByUserStep(String orderAmount) {
        Assert.assertEquals("Order amount is not as expected", orderAmount, shoppingCartPage.getOrderAmount());
    }

    @Step
    public void isShoppingCartEmptyStep() {
        Assert.assertEquals("There are still products in the Shopping Cart", "0", shoppingCartPage.getProductsInCartCount());
    }

    @Step
    public void isBackToOrdersButtonAvailableStep() {
        Assert.assertTrue("Back to orders button is not available", shoppingCartPage.isBackToOrdersButtonAvailable());
    }

    @Step
    public void userAddsBlouseToCartStep() {
        mainPage.addBlouseAndContinueShopping();
    }

    @Step
    public void userAddsTshirtToCartAndGoesToCartStep() {
        mainPage.addTshirtAndGoToShoppingCart();
    }

    @Step
    public void isBlouseAddedToCartStep() {
        Assert.assertTrue("Blouse product is not added to the Cart", shoppingCartPage.isBlouseAddedToTheCart());
    }

    @Step
    public void isTotalPriceForBlousesAsExpectedStep(String totalPriceForBlouseBeforeEdit) {
        Assert.assertEquals("Total price for the added blouse is not calculated as expected", totalPriceForBlouseBeforeEdit, shoppingCartPage.getTotalPriceForBlouse());
    }

    @Step
    public void isTshirtAddedToCartStep() {
        Assert.assertTrue("TShirt product is not added to the Cart", shoppingCartPage.isTshirtAddedToTheCart());
    }

    @Step
    public void isTotalPriceForTshirtsAsExpectedStep(String totalPriceForTshirtBeforeEdit) {
        Assert.assertEquals("Total price for the added tShirt is not calculated as expected", totalPriceForTshirtBeforeEdit, shoppingCartPage.getTotalPriceForTshirt());
    }

    @Step
    public void isTotalPriceAsExpectedStep(String totalPriceForCart) {
        Assert.assertEquals("Total price for the Cart is not calculated as expected", totalPriceForCart, shoppingCartPage.getTotalPriceForCart());
    }

    @Step
    public void userSetsBlouseQuantityStep(String newQuantity) {
        shoppingCartPage.setBlouseQuantityFromKeyboard(newQuantity);
    }

    @Step
    public void userSetsTsirtQuantityStep() {
        shoppingCartPage.setTshirtQuantityByMinusButton();
    }

    @Step
    public void isQuantityForBlouseAsUserSetStep(String editedQuantityForBlouse) {
        Assert.assertEquals("Quantity was not set from keyboard as expected", editedQuantityForBlouse, shoppingCartPage.getBlousesQuantity());
    }

    @Step
    public void isTshirtDeletedStep() {
        Assert.assertFalse("Quantity was not set to 0 and the product was not deleted", shoppingCartPage.isTshirtAddedToTheCart());
    }

    @Step
    public void isTotalPriceForEditedBlouseAsExpectedStep(String totalPriceForBlouseAfterEdit) {
        Assert.assertEquals("Total price for the edited products quantity is not calculated as expected", totalPriceForBlouseAfterEdit, shoppingCartPage.getTotalPriceForBlouse());
    }

}
