package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsEqual.equalTo;

//Basic API test, currently the tests are flaky due to the use
//of hardcoded ID's, to be changed when the UI tests using User class
//are fully developed and implemented

public class BackendTest {
@BeforeClass
public static void setup() {
RestAssured.baseURI = "http://localhost:8080";
}

@Test
public void testGetAllUsers() {
given()
    .when()
    .get("/users")
    .then()
    .statusCode(200)
    .body("size()", greaterThan(0));  // Assuming there is at least one user
}

@Test
public void getUserById() {
int userId = 26;
given()
    .when()
    .get("/users/{userId}", userId)
    .then()
    .statusCode(200)
    .body("id", equalTo(userId));
}

@Test
public void createUser() {
String user = """
        { "name": "Big", "surname": "Lebowski", "email": "bl@gmail.com", "position": "Junior Developer" }""";

Response response = given()
    .contentType(ContentType.JSON)
    .body(user)
    .when()
    .post("/users")
    .then()
    .statusCode(202)
    .extract().response();

int userId = response.path("id");
System.out.println("Created user ID: " + userId);
}

@Test
public void updateUser() {
int userId = 31;
String updatedUser = """
        { "name": "Jan", "surname": "Kogut", "email": "ak@google.com", "position": "Lead Developer" }""";

given()
    .contentType(ContentType.JSON)
    .body(updatedUser)
    .when()
    .patch("/users/{userId}", userId)
    .then()
    .statusCode(202)
    .body("name", equalTo("Jan"))
    .body("surname", equalTo("Kogut"))
    .body("email", equalTo("ak@google.com"))
    .body("position", equalTo("Lead Developer"));
}

@Test
public void removeUser() {
int userId = 30;
given()
    .when()
    .delete("/users/{userId}", userId)
    .then()
    .statusCode(202);

// Verify user is deleted
given()
    .when()
    .get("/users/{userId}", userId)
    .then()
    .statusCode(404);
    }
}
