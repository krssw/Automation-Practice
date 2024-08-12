package API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class POST {

    Response response;

    @Given("I set POST user table API endpoint")
    public void setPostEndpoint(){
        RestAssured.baseURI = "localhost:8080";
    }

    @When("I send a POST HTTP request")
    public void sendPostRequest() {
        response = RestAssured.given().body("{ " +
                "\"name\": \"John\", " +
                "\"surname\": \"Johnovic\", " +
                "\"email\": \"jonjon@gmail.com\", " +
                "\"position\": \"Business Analyst\"}")
                .post("/users");
    }
}
