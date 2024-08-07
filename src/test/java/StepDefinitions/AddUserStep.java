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

public class AddUserStep extends BaseStep {
    MainPage mainPage;
    AddUserPage addUserPage;
    WebDriverWait wait;

    public AddUserStep(TestContext testContext) { super(testContext); }

@When("user clicks add new user")
public void addUser() {
    mainPage = new MainPage(driver);
    mainPage.clickAddUserLink();
}

@And("fills in the details")
public void fillUserDetails() {
    addUserPage = new AddUserPage(driver);
    addUserPage.addNewUser("Adam", "Malysz", "am@kainos.com", "Junior Developer");
}

@And("confirms the user creation")
public void confirmCreation() {
    addUserPage.confirmUserCreation();
}

@Then("a new user is present in the list")
public void userPresence() {
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    String bodyText = driver.findElement(By.tagName("body")).getText();
    Assert.assertTrue(bodyText.contains("Adam Malysz"), "User addition successful");
    }
}