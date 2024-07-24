package StepDefinitions;

import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class BaseStep {
    protected WebDriver driver;
    protected TestContext testContext;

    public BaseStep (TestContext testContext) {
        driver = (WebDriver)testContext;
        this.testContext = testContext;
    }
}
