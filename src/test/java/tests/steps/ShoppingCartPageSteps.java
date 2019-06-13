package tests.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import utils.ParsePomManager;

import static utils.ExcelManager.getDataFromCell;

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
    public void totalPriceForBlousesShouldBeAsExpected() {
        Assert.assertEquals("Total price for the added blouse is not calculated as expected", getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C2"), shoppingCartPage.getTotalPriceForBlouse());
    }

    @Step
    public void tshirtShouldBeAddedToCart() {
        Assert.assertTrue("TShirt product is not added to the Cart", shoppingCartPage.isTshirtAddedToTheCart());

    }

    @Step
    public void totalPriceForTshirtsShouldBeAsExpected() {
        Assert.assertEquals("Total price for the added tShirt is not calculated as expected", getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C3"), shoppingCartPage.getTotalPriceForTshirt());
    }

    @Step
    public void totalPriceForCartShouldBeAsExpected() {
        Assert.assertEquals("Total price for the Cart is not calculated as expected", getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C4"), shoppingCartPage.getTotalPriceForCart());
    }


}
