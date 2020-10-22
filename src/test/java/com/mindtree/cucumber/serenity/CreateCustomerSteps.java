package com.mindtree.cucumber.serenity;

import com.mindtree.pojo.Customer;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CreateCustomerSteps {
	
	@Step
	public ValidatableResponse createCustomer(String name, String job) {
		
	Customer cust = new Customer();
	cust.setName(name);
	cust.setJob(job);
	

	return SerenityRest
	.given()
	.log()
	.all()
	.contentType(ContentType.JSON).body(cust)
	.when()
	.post("/api/client")
	.then().log().all();
		
	}

}
