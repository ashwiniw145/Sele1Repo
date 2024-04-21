package com.session3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_GetMethod {
	@Test
	void test01(){
		Response res= get("https://reqres.in/api/users/2");
		
		System.out.println("response body: "+res.getBody().asString());
		System.out.println("status code: "+res.statusCode());
		System.out.println("response time: "+res.time());
		System.out.println("response header: "+res.getHeader("Content-Type"));
		
		int ExpectedStatusCode = 200;
		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
	}
	
	@Test
	void test02() {
	
		given()
			.queryParam("page","2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.statusCode(200);
			
		
	}
}
