package StepDefinitions;

import Pages.AddUserPage;
import io.cucumber.java.en.And;
import lombok.Getter;
import utils.BasicUser;
import utils.TestContext;

public class UserCreationStep extends BaseStep {

    public UserCreationStep(TestContext testContext) { super (testContext); }

    @And("a {string} exists")
    public void createBasicUser(String userAlias) {
    BasicUser basicUser = BasicUser.builder()
            .name("John")
            .surname("Musk")
            .email("just@mail.com")
            .position("Lead Developer")
            .build();
    testContext.users().add(userAlias, basicUser);
    }
}
