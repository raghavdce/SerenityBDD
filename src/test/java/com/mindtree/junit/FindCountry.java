package com.mindtree.junit;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;
import com.mindtree.testbase.BaseClass;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FindCountry extends BaseClass {
	
	@Title("Verification of Status code and ROI for India")
	//@Test
	public void test001() {
		
		Response response = SerenityRest.given().log().all().
		when().get("/INDIA").
		then().log().all().statusCode(200).extract().response();
		String ROI  = response.jsonPath().get("[1].altSpellings[2]").toString();
		System.out.println("The value of the expected fields is : "+ROI);
		
	}
	
	@Title("Verification of Status code and ROI for xyz")
	//@Test
	public void test002() {
		
	String resBody = SerenityRest.given().log().all().
	when().get("/xyz").
	then().log().all().statusCode(404).body("message",equalTo("Not Found")).extract().response().asString();
		
	//Printing the response body in console
		System.out.println("The response for the given country is : " + resBody);
		
	}
	
}
