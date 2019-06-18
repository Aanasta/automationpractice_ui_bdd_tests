package stepDefinitions.registeredUserStepDefinitions;

import com.automationpractice.utils.ParsePomManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepDefinitions.AbstractStepDefinitions;

@RunWith(SerenityRunner.class)
public class registeredUserOrdersProductTest extends AbstractStepDefinitions {

    @Test
    public void productIsOrderedByLoggedinUserTest() {

        String email = ParsePomManager.getStringPropertyFromPom("validUserEmail");
        String password = ParsePomManager.getStringPropertyFromPom("validUserPassword");

        //GIVEN
        loginSteps.loginPageIsOpened();
        loginSteps.registeredUserLogsIntoAccount(email, password);
        productOrderingSteps.userOpensMainPage();

        //WHEN
        productOrderingSteps.userClicksBuyTshirtAndGoesToShoppingCart();
        productOrderingSteps.userNavigatesViaPurchaseWizardAndCompletesOrder();

        //THEN
        productOrderingSteps.orderConfirmationMessageShouldBeDisplayed();
        productOrderingSteps.orderAmountShouldBeAsSetByUser();
        productOrderingSteps.shoppingCartShouldBeEmpty();
        productOrderingSteps.backToOrdersButtonShouldBeVisible();
    }

}
