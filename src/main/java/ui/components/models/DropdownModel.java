package ui.components.models;

import ui.components.locators.Locators;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static support.web.WebElementHelper.*;

public class DropdownModel {

    public DropdownModel verifyDropdownPageIsDisplayed() {
        boolean isDisplayed=isElementDisplayed(Locators.DropdownPage.LBL_HEADER.get());
        String text = getText(Locators.DropdownPage.LBL_HEADER.get());
        assertTrue(isDisplayed, "Dropdown page is not displayed");
        assertEquals("Dropdown List", text);
        return this;
    }

    public DropdownModel verifyDropDownValue(String expected) {
        String text = getSelectedValueFromDropdown(Locators.DropdownPage.DPN_FIELD.get());
        assertEquals(expected, text);
        return this;
    }
}
