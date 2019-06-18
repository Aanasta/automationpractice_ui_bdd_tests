package stepDefinitions.notRegisteredUserStepDefinitions;

import com.automationpractice.utils.ParsePomManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Pending;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepDefinitions.AbstractStepDefinitions;

import static com.automationpractice.utils.ExcelManager.getDataFromCell;

@RunWith(SerenityRunner.class)
public class userHasProductsInCartTest extends AbstractStepDefinitions {

    @Test
    public void productsAreAddedToTheShoppingCartTest() {

        String totalPriceForBlouseBeforeEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C2");
        String totalPriceForTshirtBeforeEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C3");
        String totalPriceForCartBeforeEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "C4");

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

    }

    @Test
    @Pending
    public void totalPricesAreEditedInTheShoppingCartTest() {

        String editedQuantityForBlouse = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "D2");
        String totalPriceForBlouseAfterEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "E2");
        String totalPriceForCartAfterEdit = getDataFromCell(ParsePomManager.getStringPropertyFromPom("excelPricelistPath"), "E4");

        //GIVEN
        mainPage.mainPageIsOpened();
        mainPage.userAddsBlouseToCartAndContinuesShopping();
        mainPage.userAddsTshirtToCartAndGoesToCart();

        //WHEN
        shoppingCartPage.userModifiesAmountOfProductsInCart(editedQuantityForBlouse);

        //THEN
        shoppingCartPage.quantityForBlouseShouldBeAsUserSet(editedQuantityForBlouse);
        shoppingCartPage.tshirtShouldBeDeleted();
        shoppingCartPage.totalPriceForEditedBlouseShouldBeAsExpected(totalPriceForBlouseAfterEdit);
        shoppingCartPage.totalPriceForCartShouldBeAsExpected(totalPriceForCartAfterEdit);
    }

}
