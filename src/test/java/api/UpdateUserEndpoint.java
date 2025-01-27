package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateUserEndpoint extends UserService {

    @Test
    public void updateUserOperation() {
        Response response = given()
                .contentType("application/json")
                .body(updatedUser)
                .when()
                .patch("/users")
                .then()
                .statusCode(200)
                .body("name", equalTo(updatedUser.getName()))
                .extract().response();

        System.out.println(response.asString());
    }
}