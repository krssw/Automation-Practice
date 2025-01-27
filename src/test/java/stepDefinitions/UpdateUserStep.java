package stepDefinitions;

import pages.AddUserPage;
import pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContext;
import utils.dataBuilders.UserDataBuilder;
import model.UserModel;

public class UpdateUserStep extends BaseStep {

    public UpdateUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks update {string}")
    public void clickUpdate(String userAlias) {
        UserModel user = testContext.users().get(userAlias);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForElementToBeVisible(By.xpath(String.format("//tr[td[contains(text(), '%s') and contains(text(), '%s')]]", user.getName(), user.getSurname())));
        mainPage.updateUser(user.getName(), user.getSurname());
    }

    @And("makes and confirms the {string} changes")
    public void updateUserInfo(String userAlias) {
        UserModel user = UserDataBuilder.createUser();
        testContext.users().add(userAlias, user);
        AddUserPage addUserPage = new AddUserPage(driver);
        addUserPage.eraseData();
        UserDataBuilder.fillUserDetails(addUserPage, user);

    }

    @Then("{string} details are updated")
    public void confirmInfoChange(String userAlias) {
        UserModel user = testContext.users().get(userAlias);
        MainPage mainPage = new MainPage(driver);
        String bodyText = mainPage.getBodyText();
        Assert.assertTrue(bodyText.contains("%s %s".formatted(user.getName(), user.getSurname())));
    }
}