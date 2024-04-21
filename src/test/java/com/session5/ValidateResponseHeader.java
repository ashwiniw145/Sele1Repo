package com.session5;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	@Test
	void getSingleUser() {
		RequestSpecification requestSpec = RestAssured.given();
		//Specify base uri
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("/api/users/2");
		
		Response response = requestSpec.get();
		
		String contentType = response.getHeader("Connection");
		System.out.println("Value of content type: "+contentType);
		
		String connection = response.getHeader("Content-type");
		System.out.println("Value of connection: "+connection);
		
		Headers header_List = response.getHeaders();
		for(Header header:header_List) {
			System.out.println(header.getName()+" : "+header.getValue());
			
		}
		
	}
}
