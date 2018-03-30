package smoke;

import context.TestContext;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ui.components.models.BasicAuthModel;
import ui.components.models.CheckboxModel;

@Feature("Smoke")
public class CheckboxPageTests extends TestContext {


    @Test
    @Story("Checkbox Page")
    void verifyCheckboxDefaulValues() {
        open()
                .goToPage(CheckboxModel.class, "Checkboxes")
                .verifyCheckboxIsSelected("2")
                .verifyCheckboxIsNotSelected("1");
    }

    @Test
    @Story("Checkbox Page")
    void verifyUserCanChangeValuesForCheckboxes() {
        open()
                .goToPage(CheckboxModel.class, "Checkboxes")
                .verifyCheckboxIsSelected("2")
                .verifyCheckboxIsNotSelected("1");
    }

}
