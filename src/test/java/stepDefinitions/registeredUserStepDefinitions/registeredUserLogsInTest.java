package stepDefinitions.registeredUserStepDefinitions;

import com.automationpractice.utils.ParsePomManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepDefinitions.AbstractStepDefinitions;

@RunWith(SerenityRunner.class)
public class registeredUserLogsInTest extends AbstractStepDefinitions {

    @Test
    public void registeredUserLogsInTest() {

        String email = ParsePomManager.getStringPropertyFromPom("validUserEmail");
        String password = ParsePomManager.getStringPropertyFromPom("validUserPassword");

        //GIVEN
        loginSteps.loginPageIsOpened();

        //WHEN
        loginSteps.registeredUserLogsIntoAccount(email, password);

        //THEN
        loginSteps.accountPageShouldBeOpened();
        loginSteps.userShouldBeLoggedIn();
        loginSteps.logoutButtonShouldBeClickable();
    }

}
