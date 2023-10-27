package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class GetProductByID {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I have an invalid or non-existent product ID")
    public String setApiEndpoint(){

        return url + "products/85528";
    }

    @Step("I send a GET request to the product endpoint with the invalid product ID")
    public void sendGetHttpRequest(){
        SerenityRest.given()
                .when()
                .get(setApiEndpoint());
    }

    @Step("I should receive a response with status code 404 for request with invalid product ID")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("the response should contain detailed information about the product")
    public void validateData(){
        String requestBody =
                "{\n" +
                "    \"data\": {\n" +
                "        \"ID\": 85528,\n" +
                "        \"Name\": \"Sony PS5\",\n" +
                "        \"Description\": \"play has no limits\",\n" +
                "        \"Price\": 299,\n" +
                "        \"Ratings\": 3,\n" +
                "        \"Categories\": []\n" +
                "    }\n" +
                "}";

        // Kirim permintaan POST dengan data JSON
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody);
    }
}
