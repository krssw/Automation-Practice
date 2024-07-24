package StepDefinitions;

import Pages.AddUserPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class AddUserStep extends BaseStep {
    MainPage mainPage;
    AddUserPage addUserPage;

    public AddUserStep(TestContext testContext) {
        super(testContext);
    }

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
    if(driver.getPageSource().contains("Adam Malysz")) {
        System.out.println("User created successfully");
    } else {
        System.out.println("User creation failed");
    }
}
}