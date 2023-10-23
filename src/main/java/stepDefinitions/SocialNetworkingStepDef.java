package stepDefinitions;

import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RequestBodyServices;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SocialNetworkingStepDef extends BaseSteps{

    Response responseGetServiceUrl;
    Response responseGetSpecificPost;
    Response responseGetCommentUrl;
    Response responseGetSpecificComment;
    Response responseGetSpecificUsers;
    Response reponseForCreateAPost;
    Response reponseForCreateAUser;

    @Given("service is up and running")
    public void service_is_up_and_running() {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(ServiceUrl);
        responseGetServiceUrl = getCall();
        assertThat(responseGetServiceUrl.statusCode(), equalTo(200));

    }
    @When("I send GET request to get a specific post with {string}")
    public void i_send_get_request_to_get_a_specific_post_with(String id) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(PostUrl + id);
        responseGetSpecificPost = getCall();

    }
    @Then("{string}, {string} and {string} request are returned with status code of {int}")
    public void and_request_are_returned_with_status_code_of(String id, String title, String body, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(responseGetSpecificPost.statusCode(),equalTo(sCode));
        assertThat(responseGetSpecificPost.body().jsonPath().get("id"),equalTo(Integer.parseInt(id)));
        assertThat(responseGetSpecificPost.body().jsonPath().get("title"),equalTo(title));
        assertThat(responseGetSpecificPost.body().jsonPath().get("body"),equalTo(body));


    }

    @Given("JsonPlaceHolder service is up and running")
    public void json_place_holder_service_is_up_and_running() {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(ServiceUrl);
        responseGetCommentUrl = getCall();
        assertThat(responseGetCommentUrl.statusCode(),is(equalTo(200)));

    }
    @When("Get request is sent to get specific comment with {string}")
    public void get_request_is_sent_to_get_specific_comment_with(String id) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(CommentUrl + id);
        responseGetSpecificComment = getCall();

    }
    @Then("specific comment details {string}, {string}, {string} is returned with status code of {int}")
    public void specific_comment_details_is_returned_with_status_code_of(String id, String name, String email, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(responseGetSpecificComment.statusCode(),equalTo(sCode));
        assertThat(responseGetSpecificComment.body().jsonPath().get("id"),equalTo(Integer.parseInt(id)));
        assertThat(responseGetSpecificComment.body().jsonPath().get("name"),equalTo(name));
        assertThat(responseGetSpecificComment.body().jsonPath().get("email"),equalTo(email));
    }


    @When("Get request is sent to get specific User with {string}")
    public void get_request_is_sent_to_get_specific_user_with(String id) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(UserUrl + id);
        responseGetSpecificUsers = getCall();

    }
    @Then("specific user details {string}, {string}, {string}, {string}, {string} ,{string} ,{string},{string} ,{string} is returned with status code of {int}")
    public void specific_user_details_is_returned_with_status_code_of(String id, String name, String username, String email, String street, String city, String zipcode, String lat, String phone, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(responseGetSpecificUsers.statusCode(),equalTo(sCode));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("id"),equalTo(Integer.parseInt(id)));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("name"),equalTo(name));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("username"),equalTo(username));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("email"),equalTo(email));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("address.street"),equalTo(street));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("address.city"),equalTo(city));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("address.zipcode"),equalTo(zipcode));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("address.geo.lat"),equalTo(lat));
        assertThat(responseGetSpecificUsers.body().jsonPath().get("phone"),equalTo(phone));

    }


    @When("I create a new  post with the folowing details {string}, {string} and {string}")
    public void i_create_a_new_post_with_the_folowing_details_and(String userid, String title, String body) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(PostUrl);
        RequestBodyServices requestBodyServices = new RequestBodyServices();
        DocumentContext reqBody = loadJsonTemplate(PostPayLoadPath);
        requestBodyServices.setRequestBodyForPost(reqBody, userid, title, body);
        reponseForCreateAPost = getPostCall();

    }
    @Then("I should get response of {string}, {string} and {string} returned status code of {int}")
    public void i_should_get_response_of_and_returned_status_code_of(String userid, String title, String body, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(reponseForCreateAPost.statusCode(), is(equalTo(sCode)));
        assertThat(reponseForCreateAPost.body().jsonPath().get("userId"), is(equalTo(userid)));
        assertThat(reponseForCreateAPost.body().jsonPath().get("title"), is(equalTo(title)));
        assertThat(reponseForCreateAPost.body().jsonPath().get("body"), is(equalTo(body)));

    }


    @When("I create a new  post with the following details {string}, {string}, {string}, {string}, {string}, {string}, {string} and  {string}")
    public void i_create_a_new_post_with_the_following_details_and(String postId, String name, String username, String email, String street, String suite, String city, String zipcode) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(UserUrl);
        RequestBodyServices requestBodyServices = new RequestBodyServices();
        DocumentContext reqBody = loadJsonTemplate(UserPayLoadPath);
        requestBodyServices.setRequestBodyForUserPost(reqBody, postId, name, username,email,street, suite, city, zipcode );
        reponseForCreateAUser = getPostCall();

    }
    @Then("I should get response of {string}, {string},  {string}, {string}, {string}, {string}, {string}, {string} and {string} returned status code of {int}")
    public void i_should_get_response_of_and_returned_status_code_of(String name, String username, String email, String street, String suite, String city, String zipcode, String lat, String lng, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(reponseForCreateAUser.statusCode(), is(equalTo(sCode)));
       assertThat(reponseForCreateAUser.body().jsonPath().get("name"), is(equalTo(name)));
        assertThat(reponseForCreateAUser.body().jsonPath().get("username"), is(equalTo(username)));
       assertThat(reponseForCreateAUser.body().jsonPath().get("email"), is(equalTo(email)));
        assertThat(reponseForCreateAUser.body().jsonPath().get("address.street"), is(equalTo(street)));
        assertThat(reponseForCreateAUser.body().jsonPath().get("address.suite"), is(equalTo(suite)));
        assertThat(reponseForCreateAUser.body().jsonPath().get("address.city"), is(equalTo(city)));
       assertThat(reponseForCreateAUser.body().jsonPath().get("address.zipcode"), is(equalTo(zipcode)));
       assertThat(reponseForCreateAUser.body().jsonPath().get("address.geo.lat"), is(equalTo(lat)));
      assertThat(reponseForCreateAUser.body().jsonPath().get("address.geo.lng"), is(equalTo(lng)));

    }
}
