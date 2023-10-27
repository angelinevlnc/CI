package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.product.GetAllProduct;
import starter.product.GetProductByID;
import starter.product.CreateProduct;
import starter.product.DeleteProduct;
import starter.product.DeleteInvalidProduct;
import starter.product.GetProductComment;
import starter.product.GetProductRating;
import starter.product.CreateComment;
import starter.product.CreateInvalidComment;
import starter.product.CreateRating;
import starter.product.CreateInvalidRating;


public class ProductSteps {

    @Steps GetProductComment getProductComment;

    @Steps GetProductRating getProductRating;

    @Steps CreateRating createRating;

    @Steps CreateInvalidRating createInvalidRating;

    @Steps CreateComment createComment;

    @Steps CreateInvalidComment createInvalidComment;

    @Steps
    DeleteProduct deleteProduct;

    @Steps
    DeleteInvalidProduct deleteInvalidProduct;

    @Steps
    GetAllProduct getAllProduct;

    @Steps
    GetProductByID getProductByID;

    @Steps
    CreateProduct createProduct;


    @Given("I have a valid API endpoint for products")
    public void setGetAllProductApiEndpoint(){
        getAllProduct.setApiEndpoint();
    }
    @When("I send a GET request to the products endpoint")
    public void sendGetAllProductHttpRequest(){
        getAllProduct.sendGetHttpRequest();
     }
     @Then("I should receive a successful response with status code 200 for success get product request")
    public void receiveHttpResponseCodeForGetAllProduct(){
         getAllProduct.validateHttpResponseCode200();
    }
    @And("the response should contain a list of products")
    public void validateProductSize(){
        getAllProduct.validateDataNotEmpty();
    }


    @Given("I have a valid product ID")
    public void setGetAllProductByIDApiEndpoint(){
        getProductByID.setApiEndpoint();
    }
    @When("I send a GET request to the product endpoint with the valid product ID")
    public void sendGetAllProductByIDHttpRequest(){
        getProductByID.sendGetHttpRequest();
    }
    @Then("I should receive a response with status code 200 for success request with valid product ID")
    public void receiveHttpResponseCodeForGetAllProductByID(){
        getProductByID.validateHttpResponseCode200();
    }
    @And("the response should contain detailed information about the product")
    public void validateProductByIdData(){
        getProductByID.validateData();
    }


    //create product
    @Given("I have valid details for a new product")
    public void setPostApiEndpointToCreateProduct(){
        createProduct.setPostApiEndpoint();
    }
    @When("I send a POST request to the product endpoint")
    public void sendPostHttpRequestToCreateProduct(){
        createProduct.sendPostHttpRequest();
    }
    @Then("I should receive a response with status code 200")
    public void receiveHttpResponseCodeToCreateProduct(){
        createProduct.receiveHttpResponseCode200();
    }

    //delete product
    @Given("I have the ID of an existing product to delete")
    public void setDeleteProduct(){
        deleteProduct.setDeleteEndpoint();
    }
    @When("I send a DELETE request to the product endpoint")
    public void sendDeleteProductHTTPRequest(){
        deleteProduct.sendDeleteHttpRequest();
    }
    @Then("I should receive a response with status code 200 for success product delete")
    public void receiveHTTPResponseForDeleteProduct(){
        deleteProduct.validHttpresponseCode200();
    }

    @Given("I have an invalid or non-existent product ID to delete")
    public void setInvalidDeleteProduct(){
        deleteInvalidProduct.setDeleteEndpoint();
    }
    @When("I send a invalid DELETE request to the product endpoint")
    public void sendInvalidDeleteProductHTTPRequest(){
        deleteInvalidProduct.sendDeleteHttpRequest();
    }
    @Then("I should receive a response with status code 404 for invalid product delete")
    public void receiveHTTPResponseForInvalidDeleteProduct(){
        deleteInvalidProduct.validHttpresponseCode404();
    }

    //get comment
    @Given("I have valid product comment endpoint")
    public void setGetAllProductCommentApiEndpoint(){
        getProductComment.setApiEndpoint();
    }
    @When("I request the product comment with a valid ID")
    public void sendGetAllProductCommentHttpRequest(){
        getProductComment.sendGetHttpRequest();
    }
    @Then("the response status code should be 200 for success get comment request")
    public void receiveHttpResponseCodeForGetAllProductComment(){
        getProductComment.validateHttpResponseCode200();
    }

    //get rating
    @Given("I have valid product rating endpoint")
    public void setGetAllProductRatingApiEndpoint(){
        getProductRating.setApiEndpoint();
    }
    @When("I request the product rating with a valid ID")
    public void sendGetAllProductRatingHttpRequest(){
        getProductRating.sendGetHttpRequest();
    }
    @Then("the response status code should be 200 for success get ratings request")
    public void receiveHttpResponseCodeForGetAllProductRating(){
        getProductRating.validateHttpResponseCode200();
    }

    //create comment
    @Given("I have valid comment endpoint to add product")
    public void setPostApiEndpointToCreateComment(){
        createComment.setApiEndpoint();
    }
    @When("I create a product comment with a valid ID")
    public void sendPostHttpRequestToCreateComment(){
        createComment.sendPostHttpRequest();
    }
    @Then("the response status code should be 201 for succesfull request to add comment")
    public void receiveHttpResponseCodeToCreateComment(){
        createComment.receiveHttpResponseCode200();
    }

    @Given("I have invalid comment endpoint to add product")
    public void setPostApiEndpointToCreateInvalidComment(){
        createInvalidComment.setApiEndpoint();
    }
    @When("I create a product comment with an invalid ID")
    public void sendPostHttpRequestToCreateInvalidComment(){
        createInvalidComment.sendPostHttpRequest();
    }
    @Then("the response status code should be 404 for failed comment request")
    public void receiveHttpResponseCodeToCreateInvalidComment(){
        createInvalidComment.receiveHttpResponseCode404();
    }


    //create rating
    @Given("I have valid ratings endpoint to rate product")
    public void setPostApiEndpointToCreateRating(){
        createRating.setApiEndpoint();
    }
    @When("I assign a product rating with a valid ID")
    public void sendPostHttpRequestToCreateRating(){
        createRating.sendPostHttpRequest();
    }
    @Then("the response status code should be 201 for success request to add rating")
    public void receiveHttpResponseCodeToCreateRating(){
        createRating.receiveHttpResponseCode200();
    }
    @Given("I have invalid ratings endpoint to rate product")
    public void setPostApiEndpointToCreateInvalidRating(){
        createInvalidRating.setApiEndpoint();
    }
    @When("I assign a product rating with an invalid ID")
    public void sendPostHttpRequestToCreateInvalidRating(){
        createInvalidRating.sendPostHttpRequest();
    }
    @Then("the response status code should be 404 for failed request to add rating")
    public void receiveHttpResponseCodeToCreateInvalidRating(){
        createInvalidRating.receiveHttpResponseCode200();
    }




}

