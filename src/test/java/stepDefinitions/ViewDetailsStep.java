package stepDefinitions;

import pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContext;
import model.UserModel;

public class ViewDetailsStep extends BaseStep {

    public ViewDetailsStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks view {string} details")
    public void viewDetails(String userAlias) {
        UserModel user = testContext.users().get(userAlias);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForElementToBeVisible(By.xpath(String.format("//tr[td[contains(text(), '%s') and contains(text(), '%s')]]", user.getName(), user.getSurname())));
        mainPage.viewDetails(user.getName(), user.getSurname());
    }

    @Then("the {string} details are shown")
    public void detailsPageShown(String userAlias) {
        MainPage mainPage = new MainPage(driver);
        UserModel user = testContext.users().get(userAlias);
        mainPage.waitForElementToBeVisible(By.xpath(String.format("//tr[td[contains(text(), '%s') and contains(text(), '%s')]]", user.getName(), user.getSurname())));
        String bodyText = mainPage.getBodyText();
        Assert.assertTrue(bodyText.contains("User details"), "User details shown successfully");
    }
}
