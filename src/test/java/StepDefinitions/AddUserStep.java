package StepDefinitions;

import Pages.AddUserPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BasicUser;
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

@And("fills in the {string} details")
public void fillUserDetails(String userAlias) {
    BasicUser basicUser = BasicUser.builder()
            .name("Elon")
            .surname("Husk")
            .email("x@mail.com")
            .position("Lead Developer")
            .build();
    testContext.users().add(userAlias, basicUser);
}

@And("confirms the user creation")
public void confirmCreation() {
    addUserPage.confirmUserCreation();
}

@Then("a new {string} is present in the list")
public void userPresence(String name, String surname) {
    String bodyText = driver.findElement(By.tagName("body")).getText();
    Assert.assertTrue(bodyText.contains(name + " " + surname));
    }
}