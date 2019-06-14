package tests.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import utils.ParsePomManager;

public class ShoppingCartPageSteps extends AbstractPageSteps {

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
    public void backToOrdersButtonShouldBeVisible() {
        Assert.assertTrue("Back to orders button is not available", shoppingCartPage.isBackToOrdersButtonAvailable());
    }

    @Step
    public void shoppingCartShouldBeEmpty() {
        Assert.assertEquals("There are still products in the Shopping Cart", "0", shoppingCartPage.getProductsInCartCount());
    }

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
