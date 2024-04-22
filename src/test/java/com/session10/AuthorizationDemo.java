package com.session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo {
	@Test
	void getWeatherDataByCity() {
		RequestSpecification requestSpec = given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		requestSpec.queryParam("q", "delhi").queryParam("appid", "cfe26a73eee27f79a5cb6b2929896d8a");
		
		Response response = requestSpec.get();
		System.out.println("hello");
		
		/*
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Response status line: "+response.statusLine());
		System.out.println("Response status body: "+response.body().asString());
 		sosy("hello");
   sosy("hello");
   sosy("hello");

   sosy("hello");
   sosy("hello");
		*/
		
	}

}
