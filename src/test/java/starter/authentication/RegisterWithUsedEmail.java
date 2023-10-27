package starter.authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterWithUsedEmail {
    protected String url = "https://altashop-api.fly.dev/api/auth/";

    @Step("I have registration data with a used email")
    public String setPostApiEndpoint(){
        return url + "register";
    }

    @Step("I send a request to register with used email")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");
        requestBody.put("fullname", "Firstname Lastname");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("the response status code should be 400 for Register with used email")
    public void receiveHttpResponseCode400(){

        restAssuredThat(response -> response.statusCode(400));
    }
}
