package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.context.TestContext;

public class ViewDetailsStep extends BaseStep {
    MainPage mainPage;

    public ViewDetailsStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks view user details")
    public void viewDetails() {
        mainPage = new MainPage(driver);
        mainPage.clickViewDetailsLink();
    }

    @Then("the details are shown")
    public void detailsPageShown() {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("User details"), "User details shown successfully");    }
}
