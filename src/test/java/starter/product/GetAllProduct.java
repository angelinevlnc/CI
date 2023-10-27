package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.rest.SerenityRest.then;


public class GetAllProduct {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I have a valid API endpoint for products")
    public String setApiEndpoint(){

        return url + "products";
    }

    @Step("I send a GET request to the products endpoint")
    public void sendGetHttpRequest(){
        SerenityRest.given()
                .when()
                .get(setApiEndpoint());
    }

    @Step("I should receive a successful response with status code 200 for success get product request")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("the response should contain a list of products")
    public void validateDataNotEmpty(){
        then()
                .assertThat()
                .body("size()", greaterThan(0));
    }


}
