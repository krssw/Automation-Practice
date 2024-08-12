package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContext;

public class ViewDetailsStep extends BaseStep {
    MainPage mainPage;

    public ViewDetailsStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks view {string} details")
    public void viewDetails() {
        mainPage = new MainPage(driver);
        mainPage.viewDetails();
    }

    @Then("the {string} details are shown")
    public void detailsPageShown() {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("utils.context.User details"), "utils.context.User details shown successfully");    }
}
