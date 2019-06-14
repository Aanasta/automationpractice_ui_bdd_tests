package tests.stepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Pending;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.ParsePomManager;

import static utils.ExcelManager.getDataFromCell;

@RunWith(SerenityRunner.class)
public class ShoppingCartPageTest extends AbstractStepDefinitions {

    @Test
    public void productIsOrderedByLoggedinUserTest() {

        String email = ParsePomManager.getStringPropertyFromPom("validUserEmail");
        String password = ParsePomManager.getStringPropertyFromPom("validUserPassword");

        //GIVEN
        loginPage.loginPageIsOpened();
        loginPage.registeredUserLogsIntoAccount(email, password);
        accountPage.userOpensMainPage();

        //WHEN
        mainPage.userClicksBuyTshirtAndGoesToShoppingCart();
        shoppingCartPage.userNavigatesViaPurchaseWizardAndCompletesOrder();

        //THEN
        shoppingCartPage.orderConfirmationMessageShouldBeDisplayed();
        shoppingCartPage.orderAmountShouldBeAsSetByUser();
        shoppingCartPage.shoppingCartShouldBeEmpty();
        shoppingCartPage.backToOrdersButtonShouldBeVisible();
    }

    @Test
    @Pending
    public void totalPricesAreEditedInTheShoppingCartTest() {

        String totalPriceForBlouseBeforeEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C2");
        String totalPriceForTshirtBeforeEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C3");
        String totalPriceForCartBeforeEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C4");
        String editedQuantityForBlouse = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "D2");
        String totalPriceForBlouseAfterEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "E2");
        String totalPriceForCartAfterEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "E4");

        //GIVEN
        mainPage.mainPageIsOpened();

        //WHEN
        mainPage.userAddsBlouseToCartAndContinuesShopping();
        mainPage.userAddsTshirtToCartAndGoesToCart();

        //THEN
        shoppingCartPage.blouseShouldBeAddedToCart();
        shoppingCartPage.totalPriceForBlousesShouldBeAsExpected(totalPriceForBlouseBeforeEdit);
        shoppingCartPage.tshirtShouldBeAddedToCart();
        shoppingCartPage.totalPriceForTshirtsShouldBeAsExpected(totalPriceForTshirtBeforeEdit);
        shoppingCartPage.totalPriceForCartShouldBeAsExpected(totalPriceForCartBeforeEdit);

        //WHEN
        shoppingCartPage.userModifiesAmountOfProductsInCart(editedQuantityForBlouse);

        //THEN
        shoppingCartPage.quantityForBlouseShouldBeAsUserSet(editedQuantityForBlouse);
        shoppingCartPage.tshirtShouldBeDeleted();
        shoppingCartPage.totalPriceForEditedBlouseShouldBeAsExpected(totalPriceForBlouseAfterEdit);
        shoppingCartPage.totalPriceForCartShouldBeAsExpected(totalPriceForCartAfterEdit);
    }

}
