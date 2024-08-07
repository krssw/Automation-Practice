package StepDefinitions;

import io.cucumber.java.en.Given;
import utils.context.TestContext;

import static org.testng.AssertJUnit.assertTrue;

public class CommonStep extends BaseStep {
    public CommonStep(){
        super(new TestContext());
    }
    public CommonStep(TestContext testContext) {
        super(testContext);
    }

    @Given("user is on the main page")
    public void userOnMainPage() {
        System.out.println("Page title: " + driver.getTitle());
        assertTrue(driver.getTitle().contains("Journey Blog"));
    }
}
