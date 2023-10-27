package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.categories.GetCategory;
import starter.categories.GetCategoryByID;
import starter.categories.GetCategoryByInvalidID;
import starter.categories.DeleteCategory;
import starter.categories.CreateCategory;
import starter.categories.CreateEmptyCategory;


public class CategorySteps {

    @Steps
    CreateEmptyCategory createEmptyCategory;

    @Steps
    CreateCategory createCategory;

    @Steps
    GetCategory getCategory;

    @Steps
    GetCategoryByID getCategoryByID;

    @Steps
    GetCategoryByInvalidID getCategoryByInvalidID;

    @Steps
    DeleteCategory deleteCategory;


    @Given("I have a valid category endpoints")
    public void setGetApiEndpoint(){
        getCategory.setApiEndpoint();
    }
    @When("I send a request to get all category")
    public void sendGetHttpRequest(){
        getCategory.sendGetHttpRequest();
     }
     @Then("the response status code for get all category request should be 200")
    public void receiveHttpResponseCodeForGetUser(){
         getCategory.validateHttpResponseCode200();
    }


    @Given("I have a valid category ID")
    public void setGetByIDApiEndpoint(){
        getCategoryByID.setApiEndpoint();
    }
    @When("I send a request to get a category by the valid ID")
    public void sendGetByIDHttpRequest(){
        getCategoryByID.sendGetHttpRequest();
    }
    @Then("the response status code should be 200 for success get category by id")
    public void receiveHttpResponseCodeForGetByID(){
        getCategoryByID.validateHttpResponseCode200();
    }
    @And("receive valid category information")
    public void receiveCategoryDara(){
        getCategoryByID.receiveCategoryInformation();
    }

    @Given("I have an invalid category ID")
    public void setGetByInvalidIDApiEndpoint(){
        getCategoryByInvalidID.setApiEndpoint();
    }
    @When("I send a request to get a category by the invalid ID")
    public void sendGetByInvalidIDHttpRequest(){
        getCategoryByInvalidID.sendGetHttpRequest();
    }
    @Then("the response status code should be 404 for unsuccessfull request with invalid ID")
    public void receiveHttpResponseCodeForGetByInvalidID(){
        getCategoryByInvalidID.validateHttpResponseCode404();
    }

    @Given("I have a valid category ID to delete")
    public void setDeleteCategory(){
        deleteCategory.setDeleteEndpoint();
    }
    @When("I send a request to delete a category by the valid ID")
    public void sendDeleteCategoryHTTPRequest(){
        deleteCategory.sendDeleteHttpRequest();
    }
    @Then("the response status code should be 200 for success category delete")
    public void receiveHTTPResponseForDeleteCategory(){
        deleteCategory.validHttpresponseCode200();
    }


    @Given("I have valid category data")
    public void setEndpointToCreateCategory(){
        createCategory.setApiEndpoint();
    }
    @When("I send a request to create a category")
    public void sendEndpointToCreateCategory(){

        createCategory.sendPostHttpRequest();
    }
    @Then("the response status code should be 200 for success add category")
    public void receiveHTTPResponseToCreateCategory(){

        createCategory.receiveHttpResponseCode200();
    }


    @Given("I have empty category data")
    public void setEndpointToCreateEmptyCategory(){
        createEmptyCategory.setApiEndpoint();
    }
    @When("I send a request to create empty category")
    public void sendEndpointToCreateEmptyCategory(){
        createEmptyCategory.sendPostHttpRequest();
    }
    @Then("the response status code should be 404")
    public void receiveHTTPResponseToCreateEmptyCategory(){
        createEmptyCategory.receiveHttpResponseCode504();
    }

}

