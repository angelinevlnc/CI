package starter.product;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProduct {
    protected String url = "https://altashop-api.fly.dev/api/";
    @Step("I have the ID of an existing product to delete")
    public String setDeleteEndpoint(){
        return url + "products/1";
    }
    @Step("I send a DELETE request to the product endpoint")
    public void sendDeleteHttpRequest(){
        SerenityRest.given().delete(setDeleteEndpoint());
    }
    @Step("I should receive a response with status code 200 for success product delete")
    public void validHttpresponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
}
