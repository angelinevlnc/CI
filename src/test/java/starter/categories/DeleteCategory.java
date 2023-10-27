package starter.categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteCategory {
    protected String url = "https://altashop-api.fly.dev/api/";
    @Step("I have a valid category ID to delete")
    public String setDeleteEndpoint(){
        return url + "categories/1";
    }
    @Step("I send a request to delete a category by the valid ID")
    public void sendDeleteHttpRequest(){
        SerenityRest.given().delete(setDeleteEndpoint());
    }
    @Step("the response status code should be 200 for success category delete")
    public void validHttpresponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
}
