package starter.categories;

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


public class GetCategoryByID {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I have a valid category ID")
    public String setApiEndpoint(){

        return url + "categories/30444";
    }

    @Step("I send a request to get a category by the valid ID")
    public void sendGetHttpRequest(){
        SerenityRest.given()
                .when()
                .get(setApiEndpoint());
    }

    @Step("the response status code should be 200 for success get category by id")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("receive valid category information")
    public void receiveCategoryInformation(){
        String requestBody = "{\n" +
                "    \"data\": {\n" +
                "        \"ID\": 30444,\n" +
                "        \"Name\": \"gaming\",\n" +
                "        \"Description\": \"for gaming purposes\",\n" +
                "    }\n" +
                "}";

        // Kirim permintaan POST dengan data JSON
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody);
    }
}
