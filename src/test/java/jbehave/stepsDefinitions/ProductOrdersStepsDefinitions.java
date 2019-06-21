package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.*;
import org.junit.Assert;

public class ProductOrdersStepsDefinitions extends AbstractStepDefinitions {

    @Given("user opens Main page")
    public void userOpensMainPage() {
        mainPage.clickLogoAndOpenMainPage();
    }

    @When("user makes his order in the order wizard")
    @Pending
    public void userNavigatesViaPurchaseWizardAndCompletesOrder() {
        shoppingCartPage.completePurchaseByLoggedinUser();
    }

    @Then("<confirmationMessage> should be displayed")
    public void orderConfirmationMessageShouldBeDisplayed(@Named("confirmationMessage") String message) {
        Assert.assertEquals("Order is not completed", message, shoppingCartPage.getOrderConfirmationMessage());
    }

    @Then("order amount should be <expectedOrderAmount>")
    public void orderAmountShouldBeAsSetByUser(@Named("expectedOrderAmount") String orderAmount) {
        Assert.assertEquals("Order amount is not as expected", orderAmount, shoppingCartPage.getOrderAmount());
    }

    @Then("shopping cart should be empty")
    public void shoppingCartShouldBeEmpty() {
        Assert.assertEquals("There are still products in the Shopping Cart", "0", shoppingCartPage.getProductsInCartCount());
    }

    @Then("back to orders button should be available")
    public void backToOrdersButtonShouldBeVisible() {
        Assert.assertTrue("Back to orders button is not available", shoppingCartPage.isBackToOrdersButtonAvailable());
    }
}
