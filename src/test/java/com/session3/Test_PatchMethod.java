package com.session3;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test_PatchMethod {
	@Test
	void test03() {
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Ashu");
		jsondata.put("job", "QA");
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.body(jsondata.toJSONString())
		.when()
			.patch("https://reqres.in/api/users/693")
		.then()
			.statusCode(200)
			.log().all();
			
		
	}
}
