package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.TestContext;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class RemoveUserStep extends BaseStep {
    MainPage mainPage;

    public RemoveUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks remove user")
    public void addUser() {
        mainPage = new MainPage(driver);
        mainPage.removeUser();
    }

    @Then("user is removed from the list")
    public void userRemoval() {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertTrue(!bodyText.contains("Adam Malysz"));
    }
}