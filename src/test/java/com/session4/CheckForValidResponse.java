package com.session4;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CheckForValidResponse {
	
	@Test(enabled=false)
	void getSingleUser() {
		//Specify base uri
		baseURI = "https://reqres.in/api/users/2";
		
		//Get request specification of the request
		RequestSpecification requestSpec = given();
		
		Response response = requestSpec.get();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String sattusLine= response.getStatusLine();
		Assert.assertEquals(sattusLine, "HTTP/1.1 200 OK");
	}
	@Test(enabled=false)
	void getSingleUserUsingValidTableResponse() {
		//Specify base uri
				baseURI = "https://reqres.in/api/users/2";
				
				//Get request specification of the request
				RequestSpecification requestSpec = given();
				
				Response response = requestSpec.get();
				
				ValidatableResponse validateRes = response.then();
				validateRes.statusCode(200);
				validateRes.statusLine("HTTP/1.1 200 OK");
				
	}
	@Test
	void getsingleUSerByBBDStyle() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
	}


}
//