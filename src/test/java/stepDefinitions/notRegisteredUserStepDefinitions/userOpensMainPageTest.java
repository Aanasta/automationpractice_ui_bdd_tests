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
