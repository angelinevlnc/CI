package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteInvalidProduct {
    protected String url = "https://altashop-api.fly.dev/api/";
    @Step("I have an invalid or non-existent product ID to delete")
    public String setDeleteEndpoint(){
        return url + "products/9999";
    }
    @Step("I send a invalid DELETE request to the product endpoint")
    public void sendDeleteHttpRequest(){
        SerenityRest.given().delete(setDeleteEndpoint());
    }
    @Step("I should receive a response with status code 404 for invalid product delete")
    public void validHttpresponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
