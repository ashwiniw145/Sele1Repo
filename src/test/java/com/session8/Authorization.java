package com.session8;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Authorization {
	//with No authorization
	@Test(enabled=true)
	void withoutAuth() {
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		Response response = requestSpec.get();
		int SC = response.statusCode();
		System.out.println("Response status: "+SC);
		Assert.assertEquals(200, SC);
		
	}
	
	//with basic auth(non preemptive)
	@Test(enabled=true)
	void basicAuth() {
		RequestSpecification requestSpe = RestAssured.given();
		
		requestSpe.baseUri("http://postman-echo.com");
		requestSpe.basePath("/basic-auth");
		
		Response response = requestSpe.auth().basic("postman", "password").get();
		int SC = response.statusCode();
		System.out.println("Response status: "+SC);
		Assert.assertEquals(200, SC);
	}
	
	//with digest auth
		@Test
		void digestAuth() {
			RequestSpecification requestSpe = RestAssured.given();
			
			requestSpe.baseUri("https://httpbin.org");
			requestSpe.basePath("/digest-auth/undefined/ashu/ashu");
			
			Response response = requestSpe.auth().digest("ashu", "ashu").get();
			int SC = response.statusCode();
			System.out.println("Response status: "+SC);
			//Assert.assertEquals(SC, 200);
		}
		

	
		
}
