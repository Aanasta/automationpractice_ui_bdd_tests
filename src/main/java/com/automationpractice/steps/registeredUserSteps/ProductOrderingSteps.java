package com.automationpractice.steps.registeredUserSteps;

import com.automationpractice.steps.AbstractSteps;
import com.automationpractice.utils.ParsePomManager;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ProductOrderingSteps extends AbstractSteps {

    @Step
    public void userClicksBuyTshirtAndGoesToShoppingCart() {
        mainPage.addTshirtAndGoToShoppingCart();
    }

    @Step
    public void userNavigatesViaPurchaseWizardAndCompletesOrder() {
        shoppingCartPage.completePurchaseByLoggedinUser();
    }

    @Step
    public void orderConfirmationMessageShouldBeDisplayed() {
        Assert.assertEquals("Order is not completed", ParsePomManager.getStringPropertyFromPom("orderConfirmationMessage"), shoppingCartPage.getOrderConfirmationMessage());
    }

    @Step
    public void orderAmountShouldBeAsSetByUser() {
        Assert.assertEquals("Order amount is not as expected", ParsePomManager.getStringPropertyFromPom("orderAmount"), shoppingCartPage.getOrderAmount());
    }

    @Step
    public void shoppingCartShouldBeEmpty() {
        Assert.assertEquals("There are still products in the Shopping Cart", "0", shoppingCartPage.getProductsInCartCount());
    }

    @Step
    public void backToOrdersButtonShouldBeVisible() {
        Assert.assertTrue("Back to orders button is not available", shoppingCartPage.isBackToOrdersButtonAvailable());
    }

}
