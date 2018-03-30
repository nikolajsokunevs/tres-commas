package ui.components.models;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import ui.components.locators.Locators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static support.web.WebElementHelper.*;
import static java.lang.String.format;


public class CheckboxModel {

    public CheckboxModel verifyCheckboxIsSelected(String chechboxIndex) {
        boolean isSelected=isSelected(Locators.CheckboxesPage.CBX_ELEMENT_TEMPLATE.get(chechboxIndex));
        assertTrue(isSelected, format("Checkbox {0} is not selected", chechboxIndex));
        return this;
    }

    public CheckboxModel verifyCheckboxIsNotSelected(String chechboxIndex) {
        boolean isSelected=isSelected(Locators.CheckboxesPage.CBX_ELEMENT_TEMPLATE.get(chechboxIndex));
        assertTrue(isSelected, format("Checkbox {0} is not selected", chechboxIndex));
        return this;
    }

}
