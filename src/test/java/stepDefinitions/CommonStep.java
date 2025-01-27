package stepDefinitions;

import pages.AddUserPage;
import pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.TestContext;
import utils.dataBuilders.UserDataBuilder;
import model.UserModel;

public class CommonStep extends BaseStep {
    public CommonStep(TestContext testContext) {
        super(testContext);
    }

    @Given("there is a {string} user")
    public void createUserDetails(String userAlias) {
        UserModel user = UserDataBuilder.createUser();
        testContext.users().add(userAlias, user);
    }

    @And("{string} user is present in the list")
    public void createUser(String userAlias) {
        new MainPage(driver).addUser();
        UserModel user = testContext.users().get(userAlias);
        UserDataBuilder.fillUserDetails(new AddUserPage(driver), user);
    }
}
