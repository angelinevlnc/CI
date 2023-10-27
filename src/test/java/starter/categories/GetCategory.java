package starter.categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;


public class GetCategory {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I have a valid category endpoints")
    public String setApiEndpoint(){

        return url + "categories";
    }

    @Step("I send a request to get all category")
    public void sendGetHttpRequest(){
        SerenityRest.given()
                .when()
                .get(setApiEndpoint());
    }

    @Step("the response status code for get all category request should be 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }


}
