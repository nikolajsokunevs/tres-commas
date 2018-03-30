package ui.components.models;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import ui.components.locators.Locators;
import static org.junit.jupiter.api.Assertions.*;
import static support.web.WebElementHelper.*;


public class BasicAuthModel {

    public BasicAuthModel login(String login, String password){
        Alert alert= waitForAlert();
        alert.sendKeys(login + Keys.TAB.toString()+password);
        alert.accept();
        return this;
    }

    public BasicAuthModel verifyAuthenticationIsPassed(){
        String message=getText(Locators.BasicAuthPage.LBL_AUTH_PASSED_MESSAGE.get());
        assertEquals("Congratulations! You must have the proper credentials.", message);
        return this;
    }

    public BasicAuthModel verifyAuthenticationIsNotPassed(){
        waitForAlert().dismiss();
        boolean isDisplayed=isElementDisplayed(Locators.BasicAuthPage.LBL_AUTH_PASSED_MESSAGE.get());
        assertEquals(false, isDisplayed, "Basic Auth page was opened");
        isDisplayed=isElementDisplayed(Locators.BasicAuthPage.LBL_NOT_AUTHORIZED.get());
        assertEquals(true, isDisplayed, "'No authorized' label is not displayed");
        return this;
    }

}
