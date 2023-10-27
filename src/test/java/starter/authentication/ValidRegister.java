package starter.authentication;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class ValidRegister {
    protected String url = "https://altashop-api.fly.dev/api/auth/";

    @Step("I have valid registration data")
    public String setPostApiEndpoint(){
        return url + "register";
    }

    @Step("I send a request to register with valid credentials")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "yuki@mail.com");
        requestBody.put("password", "123123");
        requestBody.put("fullname", "Firstname Lastname");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("the response status code should be 200 for valid register")
    public void receiveHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("return valid data")
    public void returnValidData(){

        String requestBody =
                "{\n" +
                "    \"data\": {\n" +
                "        \"ID\": 27785,\n" +
                "        \"Fullname\": \"Firstname Lastname\",\n" +
                "        \"Email\": \"yuki@mail.com\",\n" +
                "        \"Password\": \"123123\"\n" +
                "    }\n" +
                "}";

        // Kirim permintaan POST dengan data JSON
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody);
    }

}
