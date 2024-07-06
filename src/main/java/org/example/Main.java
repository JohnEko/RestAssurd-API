package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

//
public class Main {

    private static RequestSpecification Request;
    public Main(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);

        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static Response GetPathParameters(String url, Map<String, String> pathParams) throws URISyntaxException {
       try {
           Request.pathParams(pathParams);
           return Request.get(new URI(url));
       } catch (URISyntaxException e){
           e.printStackTrace();
       }
       return null;
    }
    public static ResponseOptions<Response> PostOperationWithBodyAndPathParameters(String url, Map<String, String> pathParams, Map<String, String> body) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }
}
