package com.mindtree.testbase;

import org.junit.BeforeClass;
//import org.junit.jupiter.api.BeforeEach;

import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public static void baseTest() {
		
	//GetCountry
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
		
	//RegisterCustomer
		//RestAssured.baseURI="https://restapi.demoqa.com/customer";
		
	}

}
