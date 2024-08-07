package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.context.TestContext;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class RemoveUserStep extends BaseStep {
    MainPage mainPage;
    WebDriverWait wait;

    public RemoveUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks remove user")
    public void removeUser() {
        mainPage = new MainPage(driver);
        mainPage.clickRemoveUserLink();
    }

    @Then("user is removed from the list")
    public void userRemoval() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertTrue(!bodyText.contains("Adam Malysz"));
    }
}