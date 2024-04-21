package com.session9;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AuthorizationBearerTokenAuthenti {
	@Test
	public void bearerToken() {
		//create request specification
		RequestSpecification requestSpe = given();
		requestSpe.baseUri("https://gorest.co.in/");
		requestSpe.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "Tenalii Ramakrishna");
		payload.put("gender", "male");
		payload.put("email", "tenali14.ramakrishna@gmail.com");
		payload.put("status", "active");
		
		String authToken ="Bearer cd4b040bd5360639673bcdb669c6c1ef80a2bd91ad3665e6784dac46c8ac0343";
		
		requestSpe.headers("Authorization", authToken)
		.contentType(ContentType.JSON)
		.body(payload.toJSONString());
	
		Response response = requestSpe.post();
		
		Assert.assertEquals(response.statusCode(), 201);
		System.out.println("Response status line: "+response.statusLine());
		System.out.println("Response status body: "+response.body().asString());
		

	}
}
