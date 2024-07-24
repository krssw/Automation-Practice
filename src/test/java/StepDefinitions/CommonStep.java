package StepDefinitions;

import io.cucumber.java.en.Given;
import utils.TestContext;

import static org.testng.AssertJUnit.assertTrue;

public class CommonStep extends BaseStep {
    public CommonStep(TestContext testContext) { super(testContext);}

    @Given("user is on the main page")
    public void userOnMainPage() {
        assertTrue(driver.getTitle().contains("Journey Blog"));
    }
}
