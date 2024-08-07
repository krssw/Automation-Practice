package StepDefinitions;

import Pages.AddUserPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.context.TestContext;

import java.time.Duration;

public class UpdateUserStep extends BaseStep {
    MainPage mainPage;
    AddUserPage addUserPage;
    WebDriverWait wait;

    public UpdateUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks update user")
    public void clickUpdate() {
        mainPage = new MainPage(driver);
        mainPage.clickUpdateUserLink();
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Bob Ross"), "User update successful");
    }
}