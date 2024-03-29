package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class Test1 {
	
	@Test(priority=1)
	public void Firsttest()
	
	{
		Response response= get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode=response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@Test(priority=2)
	public void SecondTest() 
	{
		baseURI= "https://reqres.in/api";
		given().get("/users?page=2").
		then().statusCode(200).
		body("data[1].id",equalTo(8)).                                     //json path finder for json path
		log().all();
		
	}

}
