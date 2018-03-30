package smoke;

import context.TestContext;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Feature("Smoke")
public class WelcomePageTests extends TestContext {


    @Test
    @Story("Welcome Page")
    void verifyApplicationIsRunning() {
            open()
                    .verifyWelcomePageIsOpened();
    }

    @Test
    @Story("Welcome Page")
    void verifyWelcomePageContains39Links() {
        open()
                .verifyWelcomePageContainsCorrectAmountOfLink(39);
    }

    @Test
    @Story("Welcome Page")
    void verifyGitToLinkIsDisplayed() {
        open()
                .verifyLinkToGitIsDisplayed();
    }
}
