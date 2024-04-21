package com.session3;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test_PutMethod {
	@Test
	void test03() {
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Ashu");
		jsondata.put("job", "Data-Scientist");
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.body(jsondata.toJSONString())
		.when()
			.put("https://reqres.in/api/users/693")
		.then()
			.statusCode(200)
			.log().all();
			
		
	}

}
