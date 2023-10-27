package starter.authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class EmptyRegister {
    protected String url = "https://altashop-api.fly.dev/api/auth/";

    @Step("I have empty registration data")
    public String setPostApiEndpoint(){
        return url + "register";
    }

    @Step("I send a request to register with empty credentials")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "");
        requestBody.put("fullname", "");


        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("the response status code should be 400 for register with empty credentials")
    public void receiveHttpResponseCode400(){

        restAssuredThat(response -> response.statusCode(400));
    }
}
