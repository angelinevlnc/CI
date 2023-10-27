package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.rest.SerenityRest.then;


public class GetProductComment {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I have valid product comment endpoint")
    public String setApiEndpoint(){

        return url + "products/2/comments";
    }

    @Step("I request the product comment with a valid ID")
    public void sendGetHttpRequest(){
        SerenityRest.given()
                .when()
                .get(setApiEndpoint());
    }

    @Step("the response status code should be 200 for success get comment request")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }



}
