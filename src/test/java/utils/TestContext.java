package utils;

import org.openqa.selenium.WebDriver;

public class TestContext {
    public final TestContext testContext;
    public WebDriver driver;

    public TestContext(TestContext testContext) {
        this.testContext = testContext;
    }
}
