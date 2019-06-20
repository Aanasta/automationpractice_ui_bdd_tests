package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class AddingProductsToCartStepDefinitions extends AbstractStepDefinitions {

    @When("user adds blouse to cart")
    public void userAddsBlouseToCartAndContinuesShopping() {
        mainPage.addBlouseAndContinueShopping();
    }

    @When("user adds tshirt and opens the cart")
    public void userAddsTshirtToCartAndGoesToCart() {
        mainPage.addTshirtAndGoToShoppingCart();
    }

    @When("user sets blouse quantity to <editedBlouseQuantity>")
    public void userSetsBlouseQuantity(@Named("editedBlouseQuantity") String quantity) {
        shoppingCartPage.setBlouseQuantityFromKeyboard(quantity);
    }

    @When("user removes tshirt from the cart")
    public void userDeletesTshirt() {
        shoppingCartPage.setTshirtQuantityByMinusButton();
    }

    @Then("blouse should be added to cart")
    public void blouseShouldBeAddedToCart() {
        Assert.assertTrue("Blouse product is not added to the Cart", shoppingCartPage.isBlouseAddedToTheCart());
    }

    @Then("total price for blouses should be <blouseTotal>")
    public void totalPriceForBlousesShouldBeAsExpected(@Named("blouseTotal") String totalPriceForBlouseBeforeEdit) {
        Assert.assertEquals("Total price for the added blouse is not calculated as expected", totalPriceForBlouseBeforeEdit, shoppingCartPage.getTotalPriceForBlouse());
    }

    @Then("tshirt should be added to cart")
    public void tshirtShouldBeAddedToCart() {
        Assert.assertTrue("TShirt product is not added to the Cart", shoppingCartPage.isTshirtAddedToTheCart());
    }

    @Then("total price for tshirts should be <expectedTshirtTotalBeforeEdit>")
    public void totalPriceForTshirtsShouldBeAsExpected(@Named("expectedTshirtTotalBeforeEdit") String totalPriceForTshirtBeforeEdit) {
        Assert.assertEquals("Total price for the added tShirt is not calculated as expected", totalPriceForTshirtBeforeEdit, shoppingCartPage.getTotalPriceForTshirt());
    }

    @Then("total price for cart should be <cartTotal>")
    public void totalPriceForCartShouldBeAsExpected(@Named("cartTotal") String totalPriceForCart) {
        Assert.assertEquals("Total price for the Cart is not calculated as expected", totalPriceForCart, shoppingCartPage.getTotalPriceForCart());
    }

    @Then("blouse quantity should be <editedBlouseQuantity>")
    public void quantityForBlouseShouldBeAsUserSet(@Named("editedBlouseQuantity") String editedQuantity) {
        Assert.assertEquals("Quantity was not set from keyboard as expected", editedQuantity, shoppingCartPage.getBlousesQuantity());
    }

    @Then("tshirt should no longer be in the cart")
    public void tshirtShouldBeDeleted() {
        Assert.assertFalse("Quantity was not set to 0 and the product was not deleted", shoppingCartPage.isTshirtAddedToTheCart());
    }
}
