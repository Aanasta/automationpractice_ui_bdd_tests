package tests.steps;

import net.thucydides.core.annotations.Step;

public class LoginPageSteps extends AbstractPageSteps {

    @Step
    public void loginPageIsOpened() {
        loginPage.open();
    }

    @Step
    public void registeredUserLogsIntoAccount(String email, String password) {
        loginPage.loginToProfile(email, password);
    }

    @Step
    public void userFillsRequiredFieldsAndClicksRegister(String firstName, String lastName, String password, String address, String city, String state, String postalCode, String country, String phoneNumber) {
        loginPage.registerEmail();
        loginPage.fillPersonalData(firstName, lastName, password);
        loginPage.fillAddressData(address, city, state, postalCode, country, phoneNumber);
        loginPage.registerNewUser();
    }
}
