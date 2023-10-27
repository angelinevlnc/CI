package starter.categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;


public class GetCategoryByInvalidID {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I have an invalid category ID")
    public String setApiEndpoint(){

        return url + "categories/1";
    }

    @Step("I send a request to get a category by the invalid ID")
    public void sendGetHttpRequest(){
        SerenityRest.given()
                .when()
                .get(setApiEndpoint());
    }

    @Step("the response status code should be 404 for unsuccessfull request with invalid ID")
    public void validateHttpResponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }


}
