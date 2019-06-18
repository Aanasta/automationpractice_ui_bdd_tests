package com.automationpractice.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ShoppingCartPageSteps extends AbstractSteps {










    @Step
    public void blouseShouldBeAddedToCart() {
        Assert.assertTrue("Blouse product is not added to the Cart", shoppingCartPage.isBlouseAddedToTheCart());
    }

    @Step
    public void totalPriceForBlousesShouldBeAsExpected(String totalPriceForBlouseBeforeEdit) {
        Assert.assertEquals("Total price for the added blouse is not calculated as expected", totalPriceForBlouseBeforeEdit, shoppingCartPage.getTotalPriceForBlouse());
    }

    @Step
    public void tshirtShouldBeAddedToCart() {
        Assert.assertTrue("TShirt product is not added to the Cart", shoppingCartPage.isTshirtAddedToTheCart());

    }

    @Step
    public void totalPriceForTshirtsShouldBeAsExpected(String totalPriceForTshirtBeforeEdit) {
        Assert.assertEquals("Total price for the added tShirt is not calculated as expected", totalPriceForTshirtBeforeEdit, shoppingCartPage.getTotalPriceForTshirt());
    }

    @Step
    public void totalPriceForCartShouldBeAsExpected(String totalPriceForCart) {
        Assert.assertEquals("Total price for the Cart is not calculated as expected", totalPriceForCart, shoppingCartPage.getTotalPriceForCart());
    }

    @Step
    public void userModifiesAmountOfProductsInCart(String newQuantity) {
        shoppingCartPage.setBlouseQuantityFromKeyboard(newQuantity);
        shoppingCartPage.setTshirtQuantityByMinusButton();
    }

    @Step
    public void quantityForBlouseShouldBeAsUserSet(String editedQuantityForBlouse) {
        Assert.assertEquals("Quantity was not set from keyboard as expected", editedQuantityForBlouse, shoppingCartPage.getBlousesQuantity());

    }

    @Step
    public void tshirtShouldBeDeleted() {
        Assert.assertFalse("Quantity was not set to 0 and the product was not deleted", shoppingCartPage.isTshirtAddedToTheCart());
    }

    @Step
    public void totalPriceForEditedBlouseShouldBeAsExpected(String totalPriceForBlouseAfterEdit) {
        Assert.assertEquals("Total price for the edited products quantity is not calculated as expected", totalPriceForBlouseAfterEdit, shoppingCartPage.getTotalPriceForBlouse());
    }

}
