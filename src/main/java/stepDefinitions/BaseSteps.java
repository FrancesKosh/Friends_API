package stepDefinitions;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseSteps {
//    String ServiceUrl = "https://jsonplaceholder.typicode.com";
//    String PostUrl = ServiceUrl +"/posts/";
    public Headers headers;
    private String endpointPath;
    private Response response;
    public DocumentContext requestBodyJson;
    String ServiceUrl;
    String PostUrl;
    String CommentUrl;
    String UserUrl;
    String PostPayLoadPath;
    String UserPayLoadPath;

    public BaseSteps() {
        ServiceUrl = "https://jsonplaceholder.typicode.com";
        PostUrl = ServiceUrl +"/posts/";
        CommentUrl= ServiceUrl + "/comments/";
        UserUrl = ServiceUrl +"/users/";
        PostPayLoadPath = "/templatePayload/PostPayload.json";
        UserPayLoadPath = "/templatePayload/UserPayload.json";

    }

    public void setHeaders(Headers value) {
        restHeaders();
        headers = value;
    }

    private void restHeaders() {
        headers = null;
    }

    public void setHeadersWithContentType() {
        headers = new Headers(
                new Header("Content-Type", "application/json"));
        setHeaders(headers);
    }

    public void setHeadersWithContentTypeAndAccept() {
        headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("Accept", "application/json"));
        setHeaders(headers);
    }

    protected URL getURL() {
        try {
            return new URL(endpointPath);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    public Response getCall() {
        response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .when().get(getURL())
                .then().log().all().extract().response();
        return response;
    }

    public Response getPostCall() {
        response = RestAssured.given().log().all().relaxedHTTPSValidation().headers(headers)
                        .body(requestBodyJson.jsonString())
                        .when().post(getURL())
                        .then().log().all().extract().response();
        return response;
    }

    public void setEndpointPath(String endpointPath) {
        this.endpointPath = endpointPath;
    }

    public DocumentContext loadJsonTemplate(String path) {
        requestBodyJson = JsonPath.parse(this.getClass().getResourceAsStream(path));
        return requestBodyJson;
    }

    public Response getResponse() {
        return response;

    }
}
