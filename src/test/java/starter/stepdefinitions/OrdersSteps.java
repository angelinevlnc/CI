package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.orders.GetOrders;
import starter.orders.CreateOrder;
import starter.orders.CreateEmptyOrder;
import starter.orders.GetOrdersByInvalidID;


public class OrdersSteps {

    @Steps
    GetOrders getOrders;

    @Steps
    CreateOrder createOrder;

    @Steps
    CreateEmptyOrder createEmptyOrder;


    @Steps
    GetOrdersByInvalidID getOrdersByInvalidID;

    @Given("I have a valid orders endpoints")
    public void setGetApiEndpoint(){
        getOrders.setApiEndpoint();
    }
    @When("I send a request to get all orders")
    public void sendGetHttpRequest(){
         getOrders.sendGetHttpRequest();
     }
     @Then("the response status code should be 200 for success get request to get all orders")
    public void receiveHttpResponseCodeForGetUser(){
         getOrders.validateHttpResponseCode200();
    }

//    //get orders by id
//    @Given("I have a valid orders ID")
//    public void setGetByIDApiEndpoint(){
//        getOrdersByID.setApiEndpoint();
//    }
//    @When("I send a request to get an order by the valid ID")
//    public void sendGetByIDHttpRequest(){
//        getOrdersByID.sendGetHttpRequest();
//    }
//    @Then("the response status code should be 200 for valid order request")
//    public void receiveHttpResponseCodeForGetByID(){
//        getOrdersByID.verifyResponseStatusCode();
//    }

    //invalid id
    @Given("I have an invalid orders ID")
    public void setGetByInvalidIDApiEndpoint(){
        getOrdersByInvalidID.setApiEndpoint();
    }
    @When("I send a request to get an order by the invalid ID")
    public void sendGetByInvalidIDHttpRequest(){
        getOrdersByInvalidID.sendGetHttpRequest();
    }
    @Then("the response status code should be 404 for request with invalid id")
    public void receiveHttpResponseCodeForGetByInvalidID(){
        getOrdersByInvalidID.validateHttpResponseCode404();
    }

    //valid order
    @Given("I have valid order data")
    public void setOrderStepApiEndpoint(){
        createOrder.setApiEndpoint();
    }
    @When("I send a request to create an order")
    public void sendOrderStepHttpRequest(){
        createOrder.sendPostHttpRequest();
    }
    @Then("the response status code should be 200 for success add order")
    public void receiveHttpResponseCodeForOrderStep(){
        createOrder.receiveHttpResponseCode200();
    }

    //empty order
    @Given("I have empty order data")
    public void setEmptyOrderStepApiEndpoint(){
        createEmptyOrder.setApiEndpoint();
    }
    @When("I send a request to create an empty order")
    public void sendEmptyOrderStepHttpRequest(){
        createEmptyOrder.sendPostHttpRequest();
    }
    @Then("the response status code should be 400 for empty order")
    public void receiveHttpResponseCodeForEmptyOrderStep(){
        createEmptyOrder.receiveHttpResponseCode400();
    }

}

