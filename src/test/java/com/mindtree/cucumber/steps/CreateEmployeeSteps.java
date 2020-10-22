package com.mindtree.cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mindtree.pojo.Customer;
import com.mindtree.utils.TestDataPackage;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class CreateEmployeeSteps {
	
	public static RequestSpecification req;
	public static Response res;
	static Customer emp;
	
	@Given("^The end point uri to create a employee$")
	public void the_end_point_uri_to_create_a_employee() {
		emp = new Customer();
		emp.setName("Ragavendran" + TestDataPackage.custBody());  
		emp.setJob("Test Manager");
		RestAssured.baseURI="https://reqres.in";
		req = SerenityRest.given().log().all().contentType(ContentType.JSON).body(emp);
	}

	@When("^user passes the json body using the \"([^\"]*)\" method$")
	public void user_passes_the_json_body_using_the_method(String arg1) throws Throwable {
		res = req.when().post("/api/client").then().log().all().extract().response();
	}

	@Then("^verify the message \"([^\"]*)\" is displayed and status code is \"([^\"]*)\"$")
	public void verify_the_message_is_displayed_and_status_code_is(String message, String code)  {
		System.out.println("The response is : " + res.asString());
		int actualStatusCode = res.getStatusCode();
		assertEquals(code, String.valueOf(actualStatusCode));
	}
	
	

}
