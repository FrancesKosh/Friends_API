package utilities;

import com.jayway.jsonpath.DocumentContext;

public class RequestBodyServices {
    public void setRequestBodyForPost(DocumentContext requestBody,String userId, String title, String body){
     requestBody.set("userId",userId);
     requestBody.set("title", title);
     requestBody.set("body",body);

    }
    public void setRequestBodyForUserPost(DocumentContext requestBodyForUser, String postId, String name, String username, String email, String street, String suite, String city, String zipcode){
        requestBodyForUser.set("postId", postId);
        requestBodyForUser.set("name", name);
        requestBodyForUser.set("username", username);
        requestBodyForUser.set("email", email);
        requestBodyForUser.set("address.street", street);
        requestBodyForUser.set("address.suite", suite);
        requestBodyForUser.set("address.city", city);
        requestBodyForUser.set("address.zipcode", zipcode);


    }
}
