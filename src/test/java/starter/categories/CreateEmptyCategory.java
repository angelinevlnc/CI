package starter.categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.CoreMatchers.equalTo;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class CreateEmptyCategory {
    protected String url = "https://altashop-api.fly.dev/api/";
    private String bearerToken;
    private Response response;

    @Step("I have empty category data")
    public String setApiEndpoint(){
        return url + "api/categories";
    }

    @Step("I send a request to create empty category")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "");
        requestBody.put("description", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setApiEndpoint());
    }

    @Step("the response status code should be 404")
    public void receiveHttpResponseCode504() {

        restAssuredThat(response -> response.statusCode(404));
    }
}
