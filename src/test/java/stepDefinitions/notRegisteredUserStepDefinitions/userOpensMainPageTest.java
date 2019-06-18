package stepDefinitions.notRegisteredUserStepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepDefinitions.AbstractStepDefinitions;

@RunWith(SerenityRunner.class)
public class userOpensMainPageTest extends AbstractStepDefinitions {

    @Test
    public void mainPageIsOpenedTest() {

        //WHEN
        openingMainPageSteps.mainPageIsOpened();

        //THEN
        openingMainPageSteps.productsShouldBeDisplayed();
        openingMainPageSteps.searchBarShouldBeAvailable();
        openingMainPageSteps.numberOfProductsShouldBeAsExpected();
        openingMainPageSteps.mainLogoShouldBeDisplayed();
        openingMainPageSteps.mainLogoUrlShouldBeAsExpected();
        openingMainPageSteps.shoppingCartButtonShouldBeClickable();
    }

}
