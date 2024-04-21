package com.session3;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test_DeleteMethod {
	@Test
	void test03() {
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		
	.when()
		.delete("https://reqres.in/api/users/693")
	.then()
		.statusCode(204)
		.log().all();
	}
	

}
