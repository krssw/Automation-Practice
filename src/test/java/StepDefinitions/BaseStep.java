package StepDefinitions;

import org.openqa.selenium.WebDriver;
import utils.context.TestContext;
import utils.context.TestContextKey;

public class BaseStep {
    protected WebDriver driver;
    protected TestContext testContext;

    public BaseStep (TestContext testContext) {
        driver = (WebDriver) testContext.get(TestContextKey.WEB_DRIVER);
        this.testContext = testContext;
    }
}
