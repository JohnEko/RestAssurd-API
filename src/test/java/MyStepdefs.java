//package step.definations;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Assert;
import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;


public class MyStepdefs {
    private Scenario scenario;
    private Response response;
    private final String BASE_URL = "http://localhost:3000/";

    @Before
    public void before(Scenario val){
        this.scenario = val;
    }

    @Given("I performed a GET call on the {string}")
    public void iPerformedAGETCallOnThe(String url) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given().contentType(ContentType.JSON);
        response = req.when().get(new URI(url));

    }

    @Then("Response {string} is called")
    public void responseIsCalidated(String statusCode) {
        int responseStatus = response.then().extract().statusCode();
        Assert.assertEquals(statusCode, responseStatus+"");
    }

    @Given("I made a GET  request for {string}")
    public void i_made_a_get_request_for(String url) throws URISyntaxException{
//        RestAssured.baseURI =BASE_URL;
//        RestAssured.given().contentType(ContentType.JSON);


    }
    @And("I perform Get for the id number \"([^\"]*)\"$")
    public void i_perform_get_for_the_id_number(String postNum) throws URISyntaxException {
        BDDMethod.GetCallAPI(postNum);


    }
    @Then("I should see the author name as \"([^\"]*)\"$")
    public void i_should_see_the_author_name_as(String arg0) {

    }


    @Given("I perform a GET request for {string}")
    public void iPerformAGETRequestFor(String arg0) {

    }

    @Then("I should see the author name as")
    public void iShouldSeeTheAuthorNameAs() {
        BDDMethod.SimpleGetCollection();
    }

    @Then("I should the path parameter exist")
    public void iShouldThePathParameterExist() {
        BDDMethod.UsingPathParameter();
    }

    @Then("I should the Query parameter exist")
    public void iShouldTheQueryParameterExist() {
        BDDMethod.UsingQueryParameter();
    }

    @Given("I perform a POST request for {string}")
    public void iPerformAPOSTRequestFor(String arg0) {
        BDDMethod.PostRequestOperation();
    }
}
