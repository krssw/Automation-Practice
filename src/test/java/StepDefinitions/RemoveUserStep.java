package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContext;

import java.time.Duration;

public class RemoveUserStep extends BaseStep { ;
    MainPage mainPage;

    public RemoveUserStep(TestContext testContext) {
        super(testContext);
        mainPage = new MainPage(testContext.driver);
    }

    @When("user clicks remove user")
    public void addUser() {
        mainPage.clickRemoveUserLink();
    }

    @Then("user is removed from the list")
    public void userRemoval() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for up to 10 seconds
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Other Twin"));
            System.out.println("User delete unsuccessful");
        } catch (TimeoutException e) {
            System.out.println("User delete successful");
        }
    }
}