package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddingProductsToCartStepDefinitions extends AbstractStepDefinitions {

    @When("user adds blouse to cart")
    public void userAddsBlouseToCartAndContinuesShopping() {
        orderingProductsSteps.userAddsBlouseToCartStep();
    }

    @When("user adds tshirt and opens the cart")
    public void userAddsTshirtToCartAndGoesToCart() {
        orderingProductsSteps.userAddsTshirtToCartAndGoesToCartStep();
    }

    @When("user sets blouse quantity to <editedBlouseQuantity>")
    public void userSetsBlouseQuantity(@Named("editedBlouseQuantity") String quantity) {
        orderingProductsSteps.userSetsBlouseQuantityStep(quantity);
    }

    @When("user removes tshirt from the cart")
    public void userDeletesTshirt() {
        orderingProductsSteps.userSetsTsirtQuantityStep();
    }

    @Then("blouse should be added to cart")
    public void blouseShouldBeAddedToCart() {
        orderingProductsSteps.isBlouseAddedToCartStep();
    }

    @Then("total price for blouses should be <blouseTotal>")
    public void totalPriceForBlousesShouldBeAsExpected(@Named("blouseTotal") String totalPriceForBlouse) {
        orderingProductsSteps.isTotalPriceForEditedBlouseAsExpectedStep(totalPriceForBlouse);
    }

    @Then("tshirt should be added to cart")
    public void tshirtShouldBeAddedToCart() {
        orderingProductsSteps.isTshirtAddedToCartStep();
    }

    @Then("total price for tshirts should be <expectedTshirtTotalBeforeEdit>")
    public void totalPriceForTshirtsShouldBeAsExpected(@Named("expectedTshirtTotalBeforeEdit") String totalPriceForTshirtBeforeEdit) {
        orderingProductsSteps.isTotalPriceForTshirtsAsExpectedStep(totalPriceForTshirtBeforeEdit);
    }

    @Then("total price for cart should be <cartTotal>")
    public void totalPriceForCartShouldBeAsExpected(@Named("cartTotal") String totalPriceForCart) {
        orderingProductsSteps.isTotalPriceAsExpectedStep(totalPriceForCart);
    }

    @Then("blouse quantity should be <editedBlouseQuantity>")
    public void quantityForBlouseShouldBeAsUserSet(@Named("editedBlouseQuantity") String editedQuantity) {
        orderingProductsSteps.isQuantityForBlouseAsUserSetStep(editedQuantity);
    }

    @Then("tshirt should no longer be in the cart")
    public void tshirtShouldBeDeleted() {
        orderingProductsSteps.isTshirtDeletedStep();
    }

}
