package com.mindtree.cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mindtree.pojo.JiraLogin;
import com.mindtree.utils.TestDataPackage;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class JiraAuth {

	public static RequestSpecification req;
	public static Response res;
	public int statusCode;

	@Given("^The end point uri to login to Jira$")
	public void the_end_point_uri_to_login_to_Jira() {
		RestAssured.baseURI = "http://localhost:8080";
		SessionFilter session = new SessionFilter();
		req = SerenityRest.given().log().all().filter(session).contentType(ContentType.JSON);
	}
	@When("^user passes the valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_passes_the_valid_credentials_and(String userName, String password) {
		if (password.equalsIgnoreCase("Rumble@12")) {
			res = req.when().body(TestDataPackage.jiraAuth(userName, password)).post("/rest/auth/1/session").then()
					.log().all().extract().response();
		} else if (password.equalsIgnoreCase("Rumble@123")) {
			res = req.when().body(TestDataPackage.jiraAuth(userName, password)).post("/rest/auth/1/session").then()
					.log().all().extract().response();
		}
	}
	@Then("^verify the status code is \"([^\"]*)\"$")
	public void verify_the_status_code_is(String code) {
		if (code.equals("200")) {
			statusCode = res.getStatusCode();
			assertEquals(code, String.valueOf(statusCode));
		} else if (code.equals("401")) {
			statusCode = res.getStatusCode();
			assertEquals(code, String.valueOf(statusCode));
		}

	}

}
