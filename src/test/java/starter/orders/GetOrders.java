package starter.orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
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




public class GetOrders {
    private String bearerToken;
    private Response response;

    @Step("I have a valid orders endpoints")
    public void setApiEndpoint() {
        RestAssured.baseURI = "https://altashop-api.fly.dev"; // URL API yang sesuai
        bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw"; // Ganti dengan token Bearer Anda
    }

    @Step("I send a request to get all orders")
    public void sendGetHttpRequest(){
        Header header = new Header("Authorization", "Bearer " + bearerToken);
        Headers headers = new Headers(header);

        response = RestAssured.given()
                .headers(headers)
                .when()
                .get("/api/orders"); // Path endpoint API yang sesuai
    }

    @Step("the response status code should be 200 for success get request to get all orders")
    public void validateHttpResponseCode200() {
        Assert.assertEquals(200, response.getStatusCode());
    }

}
