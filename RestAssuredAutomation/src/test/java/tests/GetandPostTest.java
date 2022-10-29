package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetandPostTest {
	
	@Test
	public void TestGet()
	{
		baseURI= "https://reqres.in/api";
		given().get("/users?page=2").
		then().statusCode(200).
		body("data[4].first_name",equalTo("George")).
		body("data.first_name",hasItems("George","Rachel"));
	}
	
	@Test
	public void TestPost() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		/*map.put("name", "Kruti");
		map.put("Job", "QA");
		
		System.out.println(map);*/
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Kruti");
		request.put("Job","QA");
		
		System.out.println(request.toJSONString());
		
		baseURI= "https://reqres.in/api";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("/users").
		then().statusCode(201).
		log().all();
	}

}
