package starter.authentication;

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


public class GetUserInfo {
    private String bearerToken;
    private Response response;

    @Step("I am authenticated with valid credentials")
    public void authenticateWithValidCredentials() {
        RestAssured.baseURI = "https://altashop-api.fly.dev"; // URL API yang sesuai
        bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw"; // Ganti dengan token Bearer Anda
    }

    @Step("I send a request to get user information")
    public void sendRequestToGetUserInfo() {
        Header header = new Header("Authorization", "Bearer " + bearerToken);
        Headers headers = new Headers(header);

        response = RestAssured.given()
                .headers(headers)
                .when()
                .get("/api/auth/info"); // Path endpoint API yang sesuai
    }

    @Step("the response status code should be 200 for successesfull get")
    public void verifyResponseStatusCode() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Step("return valid user info")
    public void returnValidData(){

        String requestBody = "{\n" +
                "    \"data\": {\n" +
                "        \"ID\": 2,\n" +
                "        \"Fullname\": \"Firstname Lastname\",\n" +
                "        \"Email\": \"someone@mail.com\",\n" +
                "        \"Password\": \"123123\"\n" +
                "    }\n" +
                "}";

        // Kirim permintaan POST dengan data JSON
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody);
    }

}
