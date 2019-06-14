package tests.stepDefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.ParsePomManager;

@RunWith(SerenityRunner.class)
public class LoginPageTest extends AbstractStepDefinitions {

    @Test
    public void registeredUserLogsInTest() {

        String email = ParsePomManager.getStringPropertyFromPom("validUserEmail");
        String password = ParsePomManager.getStringPropertyFromPom("validUserPassword");

        //GIVEN
        loginPage.loginPageIsOpened();

        //WHEN
        loginPage.registeredUserLogsIntoAccount(email, password);

        //THEN
        accountPage.accountPageShouldBeOpened();
        accountPage.userShouldBeLoggedIn();
        accountPage.logoutButtonShouldBeClickable();
    }

    @Test
    public void userIsRegisteredTest() {

        String firstName = ParsePomManager.getStringPropertyFromPom("newUserFirstName");
        String lastName = ParsePomManager.getStringPropertyFromPom("newUserLastName");
        String password = ParsePomManager.getStringPropertyFromPom("newUserPassword");
        String address = ParsePomManager.getStringPropertyFromPom("newUserAddress");
        String city = ParsePomManager.getStringPropertyFromPom("newUserCity");
        String state = ParsePomManager.getStringPropertyFromPom("newUserState");
        String postalCode = ParsePomManager.getStringPropertyFromPom("newUserPostalCode");
        String country = ParsePomManager.getStringPropertyFromPom("newUserCountry");
        String phoneNumber = ParsePomManager.getStringPropertyFromPom("newUserPhone");


        //GIVEN
        loginPage.loginPageIsOpened();

        //WHEN
        loginPage.userFillsRequiredFieldsAndClicksRegister(firstName, lastName, password, address, city, state, postalCode, country, phoneNumber);

        //THEN
        accountPage.accountPageShouldBeOpened();
        accountPage.userShouldBeRegistered();
        accountPage.logoutButtonShouldBeClickable();
    }

}
