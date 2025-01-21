package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigLoader;

import static io.restassured.RestAssured.given;


public class UserService {

    private static final String USER_ID = "/users/{id}";
    private static final String USERS = "/users";
    private static final String BASE_URL = ConfigLoader.getProperty("api.url");

    public static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .build();


    public static Response addUser(User user) {
        return given()
                .spec(requestSpec)
                .body(user)
                .post()
                .then()
                .extract().response();
    }

    public static Response getUserById(String userId) {
        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .get(USER_ID)
                .then()
                .extract().response();
    }

    public static Response getAllUsers() {
        return given()
                .spec(requestSpec)
                .get(USERS)
                .then()
                .extract().response();
    }

    public static Response deleteUser(String userId, User user) {
        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .body(user)
                .delete()
                .then()
                .extract().response();
    }

    public static Response updateUser(String userId, User user) {
        return given()
                .spec(requestSpec)
                .pathParam("userId", userId)
                .body(user)
                .patch()
                .then()
                .extract().response();
    }
}