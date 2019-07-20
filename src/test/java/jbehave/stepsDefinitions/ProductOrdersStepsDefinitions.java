package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.*;

public class ProductOrdersStepsDefinitions extends AbstractStepDefinitions {

    @Given("user opens Main page")
    public void userOpensMainPage() {
        openingMainPageSteps.userOpensMainPageStep();
    }

    @When("user makes his order in the order wizard")
    public void userNavigatesViaPurchaseWizardAndCompletesOrder() {
        orderingProductsSteps.completeOrderInPurchaseWizardStep();
    }

    @Then("<confirmationMessage> should be displayed")
    public void orderConfirmationMessageShouldBeDisplayed(@Named("confirmationMessage") String message) {
        orderingProductsSteps.isOrderConfirmationDisplayedStep(message);
    }

    @Then("order amount should be <expectedOrderAmount>")
    public void orderAmountShouldBeAsSetByUser(@Named("expectedOrderAmount") String orderAmount) {
        orderingProductsSteps.isOrderAmountAsSetByUserStep(orderAmount);
    }

    @Then("shopping cart should be empty")
    public void shoppingCartShouldBeEmpty() {
        orderingProductsSteps.isShoppingCartEmptyStep();
    }

    @Then("back to orders button should be available")
    public void backToOrdersButtonShouldBeVisible() {
        orderingProductsSteps.isBackToOrdersButtonAvailableStep();
    }

}
