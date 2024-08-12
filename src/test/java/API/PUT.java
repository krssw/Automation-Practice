package API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PUT {

    Response response;

    @Given("I set PUT user table API endpoint")
    public void setPutEndpoint(){
        RestAssured.baseURI = "localhost:8080";
    }

    @When("I send PUT HTTP request")
    public void sendPostRequest() {
        response = RestAssured.given().body("{ " +
            "\"name\": \"John\", " +
            "\"surname\": \"Johnovic\", " +
            "\"email\": \"jonjon@gmail.com\", " +
            "\"position\": \"Business Analyst\"}")
            .put("/users/{userId}", "26");
    }
}
