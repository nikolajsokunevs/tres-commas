package ui.components.models;

import static org.junit.jupiter.api.Assertions.*;
import static support.web.WebElementHelper.*;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.web.WebElementHelper;
import ui.components.locators.Locators;

public class WelcomeModel {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeModel.class);

    public WelcomeModel(){
    }

    public WelcomeModel verifyWelcomePageIsOpened(){
        assertTrue( isElementDisplayed(Locators.WelcomePage.LBL_HEADER.get()), "Welcome page header is not displayed");
        assertEquals("Welcome to the-internet", getText(Locators.WelcomePage.LBL_HEADER.get()));
        assertTrue(waitForElements(Locators.WelcomePage.LNK_TESTING_PAGES.get()).size()>0, "Welcome page contains less then one example");
        return this;
    }

    public WelcomeModel verifyWelcomePageContainsCorrectAmountOfLink(int expected){
        assertEquals(expected,waitForElements(Locators.WelcomePage.LNK_TESTING_PAGES.get()).size(), "Incorrected link amount on Welcome page");
        return this;
    }


    public WelcomeModel verifyLinkToGitIsDisplayed(){
        assertTrue(isElementDisplayed(Locators.WelcomePage.LBL_FORK_ON_GIT_HUB.get()),"Link to Git is not displayed");
        return this;
    }

    public <T> T goToPage(Class<T> clazz, String name) {
        click(Locators.WelcomePage.LNK_TESTING_PAGE_TEMPLATE_NAME.get(name));
        T returnObject=null;
        try {
            returnObject=clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            logger.error(e.getMessage());
            fail(String.format("Navigation to page: {0} was failed", name));
        }
        return returnObject;
    }
}
