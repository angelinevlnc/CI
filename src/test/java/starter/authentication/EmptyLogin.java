package starter.authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class EmptyLogin {
    protected String url = "https://altashop-api.fly.dev/api/auth/";

    @Step("I have empty login credentials")
    public String setPostApiEndpoint(){
        return url + "login";
    }

    @Step("I send a request to login with empty credentials")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("the response status code should be 400")
    public void receiveHttpResponseCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }
}
