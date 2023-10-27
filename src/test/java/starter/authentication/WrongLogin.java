package starter.authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class WrongLogin {
    protected String url = "https://altashop-api.fly.dev/api/auth/";

    @Step("I have valid username and wrong password")
    public String setPostApiEndpoint(){
        return url + "login";
    }

    @Step("I send a request to login with wrong password")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "someone");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("the response status code should be 400 for wrong password login")
    public void receiveHttpResponseCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

}
