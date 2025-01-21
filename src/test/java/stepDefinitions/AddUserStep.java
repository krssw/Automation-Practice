package stepDefinitions;

import pages.AddUserPage;
import pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContext;
import model.UserModel;

public class AddUserStep extends BaseStep {

    public AddUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks add new user")
    public void addUser() {
        new MainPage(driver).addUser();
    }

    @And("fills in the {string} details")
    public void fillUserDetails(String userAlias) {
        UserModel user = testContext.users().get(userAlias);
        new AddUserPage(driver).addNewUser(
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPosition()).confirmUserCreation();
    }

    @Then("new {string} is present in the list")
    public void userPresence(String userAlias) {
        UserModel user = testContext.users().get(userAlias);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForElementToBeVisible(By.xpath(String.format("//tr[td[contains(text(), '%s') and contains(text(), '%s')]]", user.getName(), user.getSurname())));
        String bodyText = mainPage.getBodyText();
        Assert.assertTrue(bodyText.contains("%s %s".formatted(user.getName(), user.getSurname())));
    }
}