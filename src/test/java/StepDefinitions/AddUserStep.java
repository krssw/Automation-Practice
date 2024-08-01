package StepDefinitions;

import Pages.AddUserPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContext;

public class AddUserStep extends BaseStep {
    MainPage mainPage;
    AddUserPage addUserPage;

    public AddUserStep(TestContext testContext) { super(testContext); }

@When("user clicks add new user")
public void addUser() {
    mainPage = new MainPage(driver);
    mainPage.addUser();
}

@And("fills in the details {string} {string} {string}")
public void fillUserDetails(String name, String surname, String email) {
    addUserPage = new AddUserPage(driver);
    addUserPage.addNewUser(name, surname, email, "Junior Developer");
}

@And("confirms the user creation")
public void confirmCreation() {
    addUserPage.confirmUserCreation();
}

@Then("a new user is present in the list {string} {string}")
public void userPresence(String name, String surname) {
    String bodyText = driver.findElement(By.tagName("body")).getText();
    Assert.assertTrue(bodyText.contains(name + " " + surname), "utils.context.User addition successful");
    }
}