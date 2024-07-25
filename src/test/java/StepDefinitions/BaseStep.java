package StepDefinitions;

import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class BaseStep {
    protected WebDriver driver;
    protected TestContext testContext;

    public BaseStep (TestContext testContext) {
        this.driver = testContext.driver;
        this.testContext = testContext;
    }
}
