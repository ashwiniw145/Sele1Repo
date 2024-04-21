package com.session6;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ValidateJSONResponseBody {
	@Test
	void userListResponseBody() {
		//get request specification reference
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("api/users?page=2");
		
		Response response = requestSpec.get();
		ResponseBody reponseBody = response.getBody();
		String responseString = reponseBody.asString();
		System.out.println("reponse body is: "+responseString);
		
	
		Assert.assertTrue(responseString.contains("Janet"));
		
		JsonPath jsonpathview = reponseBody.jsonPath();
		String FirstName = jsonpathview.get("data[0].first_name");
		Assert.assertEquals("George", FirstName);
		
	}

}
