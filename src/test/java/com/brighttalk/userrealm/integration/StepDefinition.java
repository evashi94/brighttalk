package com.brighttalk.userrealm.integration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
    private static final String BASE_URL = "http://localhost:8080";
    private static final String CREATE_PATH = BASE_URL + "/service/user/realm";
    private static final String GET_PATH = BASE_URL + "/service/user/realm/";

    @When("^the client calls /service/user/realm/(.+)$")
    public void theClientCallsServiceUserRealmIdWithRealmId(String realmId) {

    }

    @Then("^the client receives status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int statusCode) {

    }

    @And("^the client receives realm details$")
    public void theClientReceivesRealmDetails() {
    }


    @And("^the client receives message (.+)$")
    public void theClientReceivesMessage(String message) {
    }



    @When("^the client posts to /service/user/realm with name and description$")
    public void theClientPostsToServiceUserRealmWithNameAndDescription() {

    }

    @When("^the client posts to /service/user/realm without a name$")
    public void theClientPostsToServiceUserRealmWithoutAName() {

    }

    @When("^the client posts /service/user/realm with name exists in database$")
    public void theClientPostsServiceUserRealmWithNameExistsInDatabase() {

    }
}
