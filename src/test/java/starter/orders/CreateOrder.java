
package starter.orders;

import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

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

public class CreateOrder {
    protected String url = "https://altashop-api.fly.dev/api/";
    private String bearerToken;
    private Response response;

    @Step("I have valid order data")
    public void setApiEndpoint() {
        RestAssured.baseURI = "https://altashop-api.fly.dev/"; // URL API yang sesuai
        bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw"; // Ganti dengan token Bearer Anda
    }

    @Step("I send a request to create an order")
    public void sendPostHttpRequest(){
        RestAssured.baseURI = "https://altashop-api.fly.dev"; // URL API yang sesuai
        bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw"; // Ganti dengan token Bearer Anda

        Header header = new Header("Authorization", "Bearer " + bearerToken);
        Headers headers = new Headers(header);

        // Data pesanan (order data) dalam format JSON
        String orderData = "[\n" +
                "    {\n" +
                "        \"product_id\": 2,\n" +
                "        \"quantity\": 1\n" +
                "    }\n" +
                "]";

        response = RestAssured.given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(orderData)
                .when()
                .post("/api/orders");
    }

    @Step("the response status code should be 200 for success add order")
    public void receiveHttpResponseCode200() {
        Assert.assertEquals(200, response.getStatusCode());
    }
}
