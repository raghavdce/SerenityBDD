package com.mindtree.cucumber.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class CountrySteps {

	public static RequestSpecification req;
	public static Response res;
	public static int statusCode;
	public static String resBody;

	@Given("^The end point uri to find a country details$")
	public void the_end_point_uri_to_find_a_country_details() {
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
		req = SerenityRest.given().log().all();

	}

	@When("^user passes the country \"([^\"]*)\" using get method$")
	public void user_passes_the_country_using_get_method(String country) {
		if (country.equalsIgnoreCase("India")) {
			res = req.when().get("/" + country).then().log().all().extract().response();
		} else {
			res = req.when().get("/" + country).then().log().all().extract().response();
		}

	}

	@Then("^verify the phrase \"([^\"]*)\" is present and status code is \"([^\"]*)\"$")
	public void verify_the_phrase_is_present_and_status_code_is(String name, String code) {

		if (name.equalsIgnoreCase("Republic of India") &&
		 code.equalsIgnoreCase(String.valueOf(200))) {
		System.out.println("The response is : "+res.asString());
		resBody = res.jsonPath().get("[1].altSpellings[2]").toString();
		System.out.println("The expected test is : " + resBody);
		assertEquals(resBody, name);
		statusCode = res.getStatusCode();
		System.out.println("The status code for India is : " + statusCode);
		assertEquals(Integer.valueOf(code), statusCode);

		 }
		else {
			System.out.println("The response is : "+res.asString());
			resBody = res.jsonPath().get("message").toString();
			System.out.println("The expected test is : " + resBody);
			assertEquals(resBody, name);
			statusCode = res.getStatusCode();
			System.out.println("The status code for XYZ country is : " + statusCode);
			assertEquals(Integer.valueOf(code), statusCode);
			
		}

	}

}
