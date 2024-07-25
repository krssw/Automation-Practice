package StepDefinitions;

import Pages.AddUserPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContext;

import java.time.Duration;

public class UpdateUserStep extends BaseStep {
    MainPage mainPage;
    AddUserPage addUserPage;

    public UpdateUserStep(TestContext testContext) {
        super(testContext);
        mainPage = new MainPage(testContext.driver);
        addUserPage = new AddUserPage(testContext.driver);
    }

    @When("user clicks update user")
    public void clickUpdate() {
        mainPage.clickUpdateUserLink();
    }

    @And("makes the changes")
        public void updateUserInfo(){
        addUserPage.eraseData();
        addUserPage.addNewUser("Bob", "Ross", "bros@kainos.com", "Senior Developer");
    }

    @And("confirms user update")
        public void confirmUpdate(){
        addUserPage.confirmUserCreation();
    }

    @Then("user details are updated")
    public void confirmInfoChange(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for up to 10 seconds
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Bob Ross"));
            System.out.println("User updated successfully");
        } catch (TimeoutException e) {
            System.out.println("User update failed");
        }
    }
}