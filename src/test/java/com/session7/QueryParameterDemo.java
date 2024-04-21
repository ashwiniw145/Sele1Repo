package com.session7;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo {
	@Test
	void filterData() {
		RequestSpecification requestspe = RestAssured.given();
		requestspe.baseUri("https://reqres.in/");
		requestspe.basePath("/api/users");
		requestspe.queryParam("page", 2).queryParam("id", "7");
		
		Response response = requestspe.get();
		String responseBodyString = response.getBody().asString();
		System.out.println(responseBodyString);
	}

}
