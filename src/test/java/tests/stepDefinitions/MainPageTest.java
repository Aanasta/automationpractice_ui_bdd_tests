package tests.stepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class MainPageTest extends AbstractStepDefinitions {

    @Test
    public void verifyMainPageIsOpened() {

        //WHEN
        mainPage.mainPageIsOpened();

        //THEN
        mainPage.productsShouldBeDisplayed();
        mainPage.searchBarShouldBeAvailable();
        mainPage.numberOfProductsShouldBeAsExpected();
        mainPage.mainLogoShouldBeDisplayed();
        mainPage.mainLogoUrlShouldBeAsExpected();
        mainPage.shoppingCartButtonShouldBeClickable();
    }

}
