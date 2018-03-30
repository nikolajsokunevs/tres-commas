package ui.components.locators;

import org.openqa.selenium.By;
import java.util.function.Function;
import static java.lang.String.format;

public class Locators {

    public enum WelcomePage {

        LBL_HEADER(By::className, "heading"),
        LBL_FORK_ON_GIT_HUB(By::xpath, "//img[@alt='Fork me on GitHub']"),
        LNK_TESTING_PAGES(By::cssSelector, "#content li > a"),
        LNK_TESTING_PAGE_TEMPLATE_ID(By::xpath, "//div[@id='content']/ul/li[%s]/a"),
        LNK_TESTING_PAGE_TEMPLATE_NAME(By::xpath, "//div[@id='content']/ul/li/a[text()='%s']");

        private String id;
        private Function<String, By> function;

        WelcomePage(Function<String, By> function, String id) {
            this.function=function;
            this.id=id;
        }

        public By get(){
            return function.apply(id);
        }

        public By get(String value){
            return function.apply(format(id, value));
        }
    }

    public enum BasicAuthPage {

        LBL_AUTH_PASSED_MESSAGE(By::xpath, "//div[@id='content']/div/p"),
        LBL_NOT_AUTHORIZED(By::xpath, "//body[contains(.,'Not authorized')]");
        private String id;
        private Function<String, By> function;

        BasicAuthPage(Function<String, By> function, String id) {
            this.function=function;
            this.id=id;
        }

        public By get(){
            return function.apply(id);
        }

        public By get(String value){
            return function.apply(format(id, value));
        }
    }

    public enum CheckboxesPage {
        CBX_ELEMENT_TEMPLATE(By::xpath, "//form[@id='checkboxes']/input[%s]");
        private String id;
        private Function<String, By> function;

        CheckboxesPage(Function<String, By> function, String id) {
            this.function=function;
            this.id=id;
        }

        public By get(){
            return function.apply(id);
        }

        public By get(String value){
            return function.apply(format(id, value));
        }
    }

    public enum DropdownPage {
        LBL_HEADER(By::cssSelector, "h3"),
        DPN_FIELD(By::cssSelector, "#dropdown");
        private String id;
        private Function<String, By> function;

        DropdownPage(Function<String, By> function, String id) {
            this.function=function;
            this.id=id;
        }

        public By get(){
            return function.apply(id);
        }

        public By get(String value){
            return function.apply(format(id, value));
        }
    }

}
