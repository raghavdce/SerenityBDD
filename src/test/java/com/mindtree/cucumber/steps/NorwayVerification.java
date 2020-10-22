package com.mindtree.cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class NorwayVerification {
	
	public static RequestSpecification req;
	public static Response res;
	public static int statusCode;
	public static String resBody;

	@Given("^The end point uri to find the country details$")
	public void the_end_point_uri_to_find_the_country_details() {
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
		req = SerenityRest.given().log().all();
	    
	}

	@When("^user passes the country code as \"([^\"]*)\" using get method$")
	public void user_passes_the_country_code_as_using_get_method(String country)  {
		res = req.when().get("/" + country).then().log().all().extract().response();
	    
	}

	@Then("^verify the response has the capital \"([^\"]*)\" is present and status code is \"([^\"]*)\"$")
	public void verify_the_response_has_the_capital_is_present_and_status_code_is(String capital, String code)  {
		
		System.out.println("The response is : "+res.asString());
		resBody = res.jsonPath().get("[0].capital").toString();
		System.out.println("The expected test is : " + resBody);
		assertEquals(resBody, capital);
		statusCode = res.getStatusCode();
		System.out.println("The status code for India is : " + statusCode);
		assertEquals(Integer.valueOf(code), statusCode);
	    
	}
	
}
