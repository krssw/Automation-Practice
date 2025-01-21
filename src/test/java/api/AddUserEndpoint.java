package api;

import io.restassured.response.Response;
import model.UserModel;
import org.junit.jupiter.api.Test;
import utils.TestContext;
import utils.TestContextKey;
import utils.dataBuilders.UserDataBuilder;

private final TestContext testContext;

public class AddUserEndpoint extends UserService {

    public void createNewUserDetails() {
        UserModel user = UserDataBuilder.createUser();
        testContext.set(TestContextKey.CREATED_USER, user);
        Response postResponse = UserService.addUser(user);
        testContext.set(TestContextKey.RESPONSE, postResponse);
        ResponseValidation.validateResponseStatusCode(postResponse, expectedStatusCode);
        int userId = postResponse.jsonPath().getInt("id");
        testContext.set(TestContextKey.USER_ID, userId);
    }

}