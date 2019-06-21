package jbehave.stepsDefinitions;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;

public class OpeningMainPageStepDefinitions extends AbstractStepDefinitions {

    @Then("products should be displayed")
    public void productsShouldBeDisplayed() {
        openingMainPageSteps.productsAreDisplayed();
    }

    @Then("search bar should be available")
    public void searchBarShouldBeAvailable() {
        openingMainPageSteps.searchBarIsAvailable();
    }

    @Then("number of products should be <expectedProductsNumber>")
    public void numberOfProductsShouldBeAsExpected(@Named("expectedProductsNumber") int productsNumber) {
        openingMainPageSteps.numberOfProductsIsAsExpected(productsNumber);
    }

    @Then("main logo should be displayed")
    public void mainLogoShouldBeDisplayed() {
        openingMainPageSteps.mainLogoIsDisplayed();
    }

    @Then("main logo url should be <mainLogoUrl>")
    public void mainLogoUrlShouldBeAsExpected(@Named("mainLogoUrl") String mainLogoUrl) {
        openingMainPageSteps.mainLogoUrlIsAsExpected(mainLogoUrl);
    }

    @Then("shopping cart button should be clickable")
    public void shoppingCartButtonShouldBeClickable() {
        openingMainPageSteps.shoppingCartButtonIsClickable();
    }
}
