package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.authentication.EmptyLogin;
import starter.authentication.WrongLogin;
import starter.authentication.ValidRegister;
import starter.authentication.EmptyRegister;
import starter.authentication.RegisterWithUsedEmail;
import starter.authentication.GetUserInfo;



public class AuthenticationSteps {

    @Steps
    GetUserInfo getUserInfo;

    @Steps
    RegisterWithUsedEmail registerWithUsedEmail;

    @Steps
    EmptyRegister emptyRegister;

    @Steps
    ValidRegister validRegister;


    @Steps
    EmptyLogin emptyLogin;

    @Steps
    WrongLogin wrongLogin;

    @Given("I am authenticated with valid credentials")
    public void setGetApiEndpoint(){
        getUserInfo.authenticateWithValidCredentials();
    }
     @When("I send a request to get user information")
    public void sendGetHttpRequest(){
         getUserInfo.sendRequestToGetUserInfo();
     }
     @Then("the response status code should be 200 for successesfull get")
    public void receiveHttpResponseCodeForGetUser(){
         getUserInfo.verifyResponseStatusCode();
    }
    @And("return valid user info")
    public void receiveUserInfo(){
        getUserInfo.returnValidData();
    }


    @Given("I have empty login credentials")
    public void setPostApiEndpointForEmptyLogin(){
        emptyLogin.setPostApiEndpoint();
    }
    @When("I send a request to login with empty credentials")
    public void sendPostHTTPRequestForEmptyLogin(){
        emptyLogin.sendPostHttpRequest();
    }

    @Then("the response status code should be 400")
    public void receiveValidHttp400(){
        emptyLogin.receiveHttpResponseCode400();
    }

    @Given("I have valid username and wrong password")
    public void setPostApiEndpointForWrongLogin(){
        wrongLogin.setPostApiEndpoint();
    }
    @When("I send a request to login with wrong password")
    public void sendPostHTTPRequestForWrongLogin(){
        wrongLogin.sendPostHttpRequest();
    }

    @Then("the response status code should be 400 for wrong password login")
    public void receiveValidHttp400ForWrongLogin(){
        wrongLogin.receiveHttpResponseCode400();
    }

    @Given("I have valid registration data")
    public void setPostApiEndpointForRegister(){
        validRegister.setPostApiEndpoint();
    }
    @When("I send a request to register with valid credentials")
    public void sendPostHTTPRequestForRegister(){
        validRegister.sendPostHttpRequest();
    }
    @Then("the response status code should be 200 for valid register")
    public void receiveValidHttp200ForRegister(){
        validRegister.receiveHttpResponseCode200();
    }
    @And("return valid data")
    public void ReturnValidData(){
        validRegister.returnValidData();
    }

    @Given("I have empty registration data")
    public void setPostApiEndpointForEmptyRegister(){
        emptyRegister.setPostApiEndpoint();
    }
    @When("I send a request to register with empty credentials")
    public void sendPostHTTPRequestForEmptyRegister(){
        emptyRegister.sendPostHttpRequest();
    }

    @Then("the response status code should be 400 for register with empty credentials")
    public void receiveValidHttp400forEmptyRegister(){
        emptyRegister.receiveHttpResponseCode400();
    }

    @Given("I have registration data with a used email")
    public void setPostApiEndpointForRegisterWithUsedEmail(){
        registerWithUsedEmail.setPostApiEndpoint();
    }
    @When("I send a request to register with used email")
    public void sendPostHTTPRequestForRegisterWithUsedEmail(){
        registerWithUsedEmail.sendPostHttpRequest();
    }
    @Then("the response status code should be 400 for Register with used email")
    public void receiveValidHttp200ForRegisterWithUsedEmail(){
        registerWithUsedEmail.receiveHttpResponseCode400();
    }

//
//    @Given("I set PUT endpoints")
//    public void setPutEndpoint(){
//        put.setPutEndpoint();
//
//    }
//
//    @When("I send PUT HTTP request")
//    public void sendPutHttpRequest(){
//        put.sendPutHttpRequest();
//
//    }
//
//    @And("I receive valid data for existing user")
//    public void validateDataForExistingUser(){
//        put.ValidateDataForExistingUser();
//
//    }
//
//    @Given("I set DELETE endpoints")
//    public void setDeleteEndpoint(){
//        delete.setDeleteEndpoint();
//
//
//    }
//    @When("I send DELETE HTTP request")
//    public void sendDeleteHttpRequest(){
//        delete.sendDeleteHttpRequest();
//
//    }
//
//    @Then("I receive valid HTTP response code 204")
//    public void validHttpResponseCode204(){
//        delete.validHttpresponseCode204();
//
//    }
}

