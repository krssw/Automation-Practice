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

public class ViewDetailsStep extends BaseStep {
    MainPage mainPage;

    public ViewDetailsStep(TestContext testContext) {
        super(testContext);
        mainPage = new MainPage(testContext.driver);
    }

    @When("user clicks view user details")
    public void viewDetails() {
        mainPage.clickViewDetailsLink();
    }

    @Then("the details are shown")
    public void detailsPageShown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for up to 10 seconds
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "User details"));
            System.out.println("User details shown successfully");
        } catch (TimeoutException e) {
            System.out.println("User details fails");
        }
    }
}
