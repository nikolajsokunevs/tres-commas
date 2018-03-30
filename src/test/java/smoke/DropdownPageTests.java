package smoke;

import context.TestContext;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ui.components.locators.Locators;
import ui.components.models.CheckboxModel;
import ui.components.models.DropdownModel;

@Feature("Smoke")
public class DropdownPageTests extends TestContext {

    @Test
    @Story("Dropdown Page")
    void verifyDropdownPageIsDisplayed() {
        open()
                .goToPage(DropdownModel.class, "Dropdown")
                .verifyDropdownPageIsDisplayed();
    }

    @Test
    @Story("Dropdown Page")
    void verifyDropdownFieldDefaulValue() {
        open()
                .goToPage(DropdownModel.class, "Dropdown")
                .verifyDropDownValue("Please select an option");
    }
}
