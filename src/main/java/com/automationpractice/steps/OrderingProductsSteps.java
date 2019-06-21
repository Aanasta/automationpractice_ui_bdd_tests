package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OrderingProductsSteps extends AbstractSteps {

    @Step
    public void userClicksBuyTshirtAndGoesToShoppingCart() {
        mainPage.addTshirtAndGoToShoppingCart();
    }

    @Step
    public void userNavigatesViaPurchaseWizardAndCompletesOrder() {
        shoppingCartPage.completePurchaseByLoggedinUser();
    }

    @Step
    public void orderConfirmationMessageShouldBeDisplayed(String orderConfirmationMessage) {
        Assert.assertEquals("Order is not completed", orderConfirmationMessage, shoppingCartPage.getOrderConfirmationMessage());
    }

    @Step
    public void orderAmountShouldBeAsSetByUser(String orderAmount) {
        Assert.assertEquals("Order amount is not as expected", orderAmount, shoppingCartPage.getOrderAmount());
    }

    @Step
    public void shoppingCartShouldBeEmpty() {
        Assert.assertEquals("There are still products in the Shopping Cart", "0", shoppingCartPage.getProductsInCartCount());
    }

    @Step
    public void backToOrdersButtonShouldBeVisible() {
        Assert.assertTrue("Back to orders button is not available", shoppingCartPage.isBackToOrdersButtonAvailable());
    }

    @Step
    public void addBlouseToCartAndContinueShopping() {
        mainPage.addBlouseAndContinueShopping();
    }

    @Step
    public void addsTshirtToCartAndGoToCart() {
        mainPage.addTshirtAndGoToShoppingCart();
    }

    @Step
    public void editBlouseQuantity(String newQuantity) {
        shoppingCartPage.setBlouseQuantityFromKeyboard(newQuantity);
    }

    @Step
    public void editTshirtQuantity() {
        shoppingCartPage.setTshirtQuantityByMinusButton();
    }

    @Step
    public void blouseIsAddedToCart() {
        Assert.assertTrue("Blouse product is not added to the Cart", shoppingCartPage.isBlouseAddedToTheCart());
    }

    @Step
    public void totalPriceForBlousesIsAsExpected(String totalPriceForBlouseBeforeEdit) {
        Assert.assertEquals("Total price for the added blouse is not calculated as expected", totalPriceForBlouseBeforeEdit, shoppingCartPage.getTotalPriceForBlouse());
    }

    @Step
    public void tshirtIsAddedToCart() {
        Assert.assertTrue("TShirt product is not added to the Cart", shoppingCartPage.isTshirtAddedToTheCart());
    }

    @Step
    public void totalPriceForTshirtsIsAsExpected(String totalPriceForTshirtBeforeEdit) {
        Assert.assertEquals("Total price for the added tShirt is not calculated as expected", totalPriceForTshirtBeforeEdit, shoppingCartPage.getTotalPriceForTshirt());
    }

    @Step
    public void totalPriceForCartIsAsExpected(String totalPriceForCart) {
        Assert.assertEquals("Total price for the Cart is not calculated as expected", totalPriceForCart, shoppingCartPage.getTotalPriceForCart());
    }

    @Step
    public void quantityForBlouseIsAsUserSet(String editedQuantityForBlouse) {
        Assert.assertEquals("Quantity was not set from keyboard as expected", editedQuantityForBlouse, shoppingCartPage.getBlousesQuantity());
    }

    @Step
    public void tshirtIsDeleted() {
        Assert.assertFalse("Quantity was not set to 0 and the product was not deleted", shoppingCartPage.isTshirtAddedToTheCart());
    }

    @Step
    public void totalPriceForEditedBlouseShouldBeAsExpected(String totalPriceForBlouseAfterEdit) {
        Assert.assertEquals("Total price for the edited products quantity is not calculated as expected", totalPriceForBlouseAfterEdit, shoppingCartPage.getTotalPriceForBlouse());
    }

}
