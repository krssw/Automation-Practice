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

public class AddUserStep extends BaseStep {
    MainPage mainPage;
    AddUserPage addUserPage;

    public AddUserStep(TestContext testContext) {
        super(testContext);
        mainPage = new MainPage(testContext.driver);
        addUserPage = new AddUserPage(testContext.driver);
    }

    @When("user clicks add new user")
public void addUser() {
    mainPage.clickAddUserLink();
}

@And("fills in the details")
public void fillUserDetails() {
    addUserPage.addNewUser("Adam", "Malysz", "am@kainos.com", "Junior Developer");
}

@And("confirms the user creation")
public void confirmCreation() {
    addUserPage.confirmUserCreation();
}

@Then("a new user is present in the list")
public void userPresence() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for up to 10 seconds
    try {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Adam Malysz"));
        System.out.println("User creation successful");
    } catch (TimeoutException e) {
        System.out.println("User creation failed");
    }
}
}