package API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE {

    Response response;

    @Given("I set DELETE user table API endpoint")
    public void setDeleteEndpoint() {
        RestAssured.baseURI = "localhost:8080";
    }

    @When("I send a DELETE HTTP request")
    public void sendDeleteRequest() {
        response = RestAssured.delete("/users/{userId}", "123");
    }
}


