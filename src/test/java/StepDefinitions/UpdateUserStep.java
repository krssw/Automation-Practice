package StepDefinitions;

import Pages.AddUserPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContext;

public class UpdateUserStep extends BaseStep {
    MainPage mainPage;
    AddUserPage addUserPage;

    public UpdateUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks update user")
    public void clickUpdate() {
        mainPage = new MainPage(driver);
        mainPage.updateUser();
    }

    @And("makes the changes")
    public void updateUserInfo(){
        addUserPage = new AddUserPage(driver);
        addUserPage.eraseData();
        addUserPage.addNewUser("Bob", "Ross", "bros@kainos.com", "Senior Developer");
    }

    @And("confirms user update")
    public void confirmUpdate(){
        addUserPage.confirmUserCreation();
    }

    @Then("user details are updated")
    public void confirmInfoChange(){
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Bob Ross"), "utils.context.User update successful");
    }
}