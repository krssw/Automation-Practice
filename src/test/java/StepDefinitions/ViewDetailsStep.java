package StepDefinitions;

import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class ViewDetailsStep extends BaseStep {
    MainPage mainPage;

    public ViewDetailsStep(TestContext testContext) {
        super(testContext);
    }

    @When("user clicks view user details")
    public void addUser() {
        mainPage = new MainPage(driver);
        mainPage.clickViewDetailsLink();
    }

    @Then("the details are shown")
    public void userRemoval() {
        if (driver.getPageSource().contains("User Details")) {
            System.out.println("User details page success");
        } else {
            System.out.println("User details page fail");
        }
    }


}
