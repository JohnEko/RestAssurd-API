
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
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class BDDMethod {

    public static void GetCallAPI(String postNum) {

        // RestAssured.baseURI =BASE_URL;
        RestAssured.given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s", postNum)).
                then().body("author", is("James"));
    }
// Get Operation
    public static void SimpleGetCollection() {
        given().contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", containsInAnyOrder("James", "Dom", "Ashini", "Zen")).statusCode(200);

    }

    public static void UsingPathParameter() {
        given().contentType(ContentType.JSON)
                .with()
                    .pathParam("post", 2)
                .when()
                     .get("http://localhost:3000/posts/{post}")
                .then()
                .body("author", containsString("Dom"));
    }
    public static void UsingQueryParameter() {
        given().contentType(ContentType.JSON)
                .with()
                     .queryParam("id", 2)
                .when()
                     .get("http://localhost:3000/posts/")
                .then()
                    .body("author", hasItem("Dom"));
    }
//Post Operation to generates data to the API payload
    public  static void PostRequestOperation(){
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("id", "5");
        postContent.put("title", "Server Admin");
        postContent.put("author", "David");

        given().contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when()
                .post("http://localhost:3000/posts")
                .then()
                .body("author", is("David"));

    }
}
