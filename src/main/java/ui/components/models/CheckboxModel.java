package ui.components.models;

import ui.components.locators.Locators;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static support.web.WebElementHelper.*;
import static java.lang.String.format;

public class CheckboxModel {

    public CheckboxModel verifyCheckboxIsSelected(String chechboxIndex) {
        boolean isSelected=isSelected(Locators.CheckboxesPage.CBX_ELEMENT_TEMPLATE.get(chechboxIndex));
        assertTrue(isSelected, format("Checkbox %s is not selected", chechboxIndex));
        return this;
    }

    public CheckboxModel verifyCheckboxIsNotSelected(String chechboxIndex) {
        boolean isSelected=isSelected(Locators.CheckboxesPage.CBX_ELEMENT_TEMPLATE.get(chechboxIndex));
        assertFalse(isSelected, format("Checkbox %s is selected", chechboxIndex));
        return this;
    }

    public CheckboxModel setValueForCheckboxes(boolean firstCheckboxValue, boolean secondCheckboxValue) {
        setValueForCheckbox(Locators.CheckboxesPage.CBX_ELEMENT_TEMPLATE.get("1"), firstCheckboxValue);
        setValueForCheckbox(Locators.CheckboxesPage.CBX_ELEMENT_TEMPLATE.get("2"), secondCheckboxValue);
        return this;
    }
}
