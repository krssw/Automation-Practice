package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.TestContext;

import static org.testng.AssertJUnit.assertTrue;

public class CommonStep extends BaseStep {
    public CommonStep(TestContext testContext) {
        super(testContext);
    }

    public Response response;

    @Given("user is on the main page")
    public void userOnMainPage() {
        assertTrue(driver.getTitle().contains("Journey Blog"));
    }

    @Then("the API should respond with status code 202")
    public void userIsRemoved() {
        Assert.assertEquals(202, response.getStatusCode());
    }
}
