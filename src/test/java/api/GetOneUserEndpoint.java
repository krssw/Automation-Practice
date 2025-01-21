package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetOneUserEndpoint extends UserService {
    public void getOneUserOperation(String userId) {
        Response response = given()
                .pathParam("userId", userId)
                .when()
                .get("/users/{userId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(userId))
                .extract().response();

        System.out.println(response.asString());
    }
}