package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class RemoveUserStep extends BaseStep { ;
    MainPage mainPage;

    public RemoveUserStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks remove user")
    public void addUser() {
        mainPage = new MainPage(driver);
        mainPage.clickRemoveUserLink();
    }

    @Then("user is removed from the list")
    public void userRemoval() {
        if (driver.getPageSource().contains("Other Twin")) {
            System.out.println("User delete unsuccessful");
        } else {
            System.out.println("User delete successful");
        }
    }
}