package smoke;

import context.TestContext;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ui.components.models.BasicAuthModel;

@Feature("Smoke")
public class BasicAuthPageTests extends TestContext {


    @Test
    @Story("Basic Auth Page")
    void verifyLoginWorksProperlyWithCorrectCredentials() {
        open()
                .goToPage(BasicAuthModel.class, "Basic Auth")
                .login("admin", "admin")
                .verifyAuthenticationIsPassed();
    }

    @Test
    @Story("Basic Auth Page")
    void verifyLoginWorksProperlyWithIncorrectCredentials() {
        open()
                .goToPage(BasicAuthModel.class, "Basic Auth")
                .login("admin", "password")
                .verifyAuthenticationIsNotPassed();
    }
}
