package com.mindtree.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mindtree.cucumber.serenity.CreateCustomerSteps;
import com.mindtree.utils.TestDataPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class RegisterCustomer {
	
	static String name = "Ragavendran V"+TestDataPackage.custBody();
	static String job = "Test Lead"+TestDataPackage.custBody();
	
	@Steps
	CreateCustomerSteps custStep;
	
	@Title("To register a customer")
	//@Test
	public void createCustomer() {
		
		RestAssured.baseURI="https://reqres.in";
		custStep.createCustomer(name, job)
		.statusCode(201);
		
	}
	
	//@Test
	public void createdummy() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		SerenityRest.given().log().all()
		.contentType(ContentType.JSON).body(TestDataPackage.employee())
		.when()
		.post("/create")
		.then().log().all()
		.statusCode(201);
		
	}
}
