package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class CreateProduct {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I have valid details for a new product")
    public String setPostApiEndpoint(){
        return url + "products";
    }

    @Step("I send a POST request to the product endpoint")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Sony PS5");
        requestBody.put("description", "play has no limits");
        requestBody.put("price", 299);

// Buat JSON Array untuk categories
        JSONArray categories = new JSONArray();
        categories.add(1); // Menggunakan add() untuk menambahkan elemen ke dalam JSON Array
        requestBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("I should receive a response with status code 200")
    public void receiveHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }



}
