package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchandDeleteTest {
	
	@Test
	public void TestPut() 
	{
		
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
		when().put("/users/2").
		then().statusCode(200).
		log().all();
	}
	
	@Test
	public void TestPatch() 
	{
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Kruti");
		request.put("Job","QA");
		
		System.out.println(request.toJSONString());
		
		baseURI= "https://reqres.in";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().patch("/api/users/2").
		then().statusCode(200).
		log().all();
	}
	
	@Test
	public void TestDelete() 
	{
		
		
		baseURI= "https://reqres.in";
		
	
		when().delete("/api/users/2").
		then().statusCode(204).
		log().all();
	}


}
