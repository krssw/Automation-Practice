package stepDefinitions;

import pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContext;
import model.UserModel;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class RemoveUserStep extends BaseStep {


    public RemoveUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks remove {string}")
    public void removeUser(String userAlias) {
        UserModel user = testContext.users().get(userAlias);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForElementToBeVisible(By.xpath(String.format("//tr[td[contains(text(), '%s') and contains(text(), '%s')]]", user.getName(), user.getSurname())));
        mainPage.removeUser(user.getName(), user.getSurname());
    }

    @Then("{string} is removed from the list")
    public void userIsRemoved(String userAlias) {
        UserModel user = testContext.users().get(userAlias);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForElementToBeInvisible(By.xpath(String.format("//tr[td[contains(text(), '%s') and contains(text(), '%s')]]", user.getName(), user.getSurname())));
        String bodyText = mainPage.getBodyText();
        Assert.assertFalse(bodyText.contains("%s %s".formatted(user.getName(), user.getSurname())));
    }
}