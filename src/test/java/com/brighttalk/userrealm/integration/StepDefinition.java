package com.brighttalk.userrealm.integration;

import com.brighttalk.userrealm.dto.NameDescriptionDto;
import com.brighttalk.userrealm.dto.RealmDto;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

import java.util.List;

public class StepDefinition {

    private RequestSpecification requestSpecification;
    private Response response;

    public StepDefinition() {
    }

    @When("^the client calls /service/user/realm/(.+)$")
    public void theClientCallsServiceUserRealmIdWithRealmId(String realmId) {
        requestSpecification = given();
        response = requestSpecification.when().get("http://localhost:8080/service/user/realm/" + realmId);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("^the client receives realm details$")
    public void theClientReceivesRealmDetails(List<String> responseFields) {
        responseFields.forEach((field) -> response.then().body("$", hasKey(field)));
    }


    @And("^the client receives message (.+)$")
    public void theClientReceivesMessage(String message) {
        response.then().body("$", hasValue(message));
    }


    @When("^the client posts to /service/user/realm with (.+) and (.+)$")
    public void theClientPostsToServiceUserRealmWithNameAndDescription(String name, String description) throws JSONException {
        name+="1";
        JSONObject requestBOdy = new JSONObject()
                .put("name", name)
                .put("description", description);
        requestSpecification = given().body(requestBOdy.toString()).contentType(ContentType.JSON);
        response = requestSpecification.when().post("http://localhost:8080/service/user/realm");

    }

    @When("^the client posts to /service/user/realm without a name$")
    public void theClientPostsToServiceUserRealmWithoutAName() {
        requestSpecification = given().body(new NameDescriptionDto(null, "description")).contentType(ContentType.JSON);
        response = requestSpecification.when().post("http://localhost:8080/service/user/realm");

    }

    @When("^the client posts /service/user/realm with name exists in database$")
    public void theClientPostsServiceUserRealmWithNameExistsInDatabase() {
        requestSpecification = given().body(new NameDescriptionDto("name", "description")).contentType(ContentType.JSON);
        response = requestSpecification.when().post("http://localhost:8080/service/user/realm");

    }
}
