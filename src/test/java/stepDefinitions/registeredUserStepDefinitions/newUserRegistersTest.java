package stepDefinitions.registeredUserStepDefinitions;

import com.automationpractice.utils.ParsePomManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Pending;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepDefinitions.AbstractStepDefinitions;

@RunWith(SerenityRunner.class)
public class newUserRegistersTest extends AbstractStepDefinitions {

    @Test
    @Pending
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
        registrationSteps.loginPageIsOpened();

        //WHEN
        registrationSteps.userFillsRequiredFieldsAndClicksRegister(firstName, lastName, password, address, city, state, postalCode, country, phoneNumber);

        //THEN
        registrationSteps.accountPageShouldBeOpened();
        registrationSteps.userShouldBeRegistered();
        registrationSteps.logoutButtonShouldBeClickable();
    }

}
