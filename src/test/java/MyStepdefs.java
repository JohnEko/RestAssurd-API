//package step.definations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.internal.multipart.RestAssuredMultiPartEntity;
import io.restassured.internal.proxy.RestAssuredProxySelector;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Main;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Assert;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import io.cucumber.datatable.DataTable;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MyStepdefs {
    private Scenario scenario;
    private Response response;
    //private Response PostOperationWithBodyAndPathParameters;

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

    //perform post operation with pathparameter snd bodyparameter together
    @Given("I perform a POST request for {string} with body")
    public void iPerformAPOSTRequestForWithBody(String url, DataTable table) throws Throwable {
        var data = table.cell(1,0);

        //Create a hashMap to map the name
        HashMap<String, String> body = new HashMap<>();
        //add the name to the data
        body.put("name", data);

        //Get the path parameters
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("userNum", data);
 
        //Perform post operation
       response = (Response) Main.PostOperationWithBodyAndPathParameters(url, pathParams, body);
    }

    @Then("I should the see the request arrive as {string}")
    public void iShouldTheSeeTheRequestArriveAs(String name) throws Throwable{
        assertThat(response.getBody().jsonPath().get("name"), equalTo(name));

    }
}
