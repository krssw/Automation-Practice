package API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET {

    Response response;

    @Given("I set GET user table API endpoint")
    public void setGetEndpoint(){
        RestAssured.baseURI = "localhost:8080";
    }

    @When("I send GET HTTP request")
    public void sendGetRequest() {
        response = RestAssured.get("/users/{userId}", "12");
    }
}
