package GETAPITestWithBDD;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GoRestAPITest {
	
	@Test
	public void getSingleUser() {
		RestAssured.baseURI = "https://gorest.co.in";
		
Response response = given()
			.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
				.when()
					.get("/public/v2/users/7820543");

	System.out.println("status code: " + response.statusCode());
	System.out.println("statuc line: " + response.statusLine());


	Assert.assertEquals(response.statusCode(), 200);
	Assert.assertTrue(response.statusLine().contains("200 OK"));
	
	response.prettyPrint();
	//fetch the json response body
	
	JsonPath js = response.jsonPath();
	
	int userId= js.getInt("id");
	System.out.println("user Id: " +userId);
	Assert.assertEquals(userId , 7820543);
	
	String userName= js.getString("name");
	System.out.println("user name: " + userName);
	Assert.assertEquals(userName , "Girija Nayar");
	
	String status= js.getString("status");
	System.out.println("user status: " + status);
	Assert.assertEquals(status , "active");
	
	}
	
	
	@Test
	public void getSAllUsers() {
		RestAssured.baseURI = "https://gorest.co.in";
		
Response response = given()
			.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
				.when()
					.get("/public/v2/users");

	System.out.println("status code: " + response.statusCode());
	System.out.println("statuc line: " + response.statusLine());


	Assert.assertEquals(response.statusCode(), 200);
	Assert.assertTrue(response.statusLine().contains("200 OK"));
	
	response.prettyPrint();

	
	JsonPath js = response.jsonPath();
	List<Integer> idList= js.getList("id");
	System.err.println(idList);
	

	List<String> nameList= js.getList("name");
	System.err.println(nameList);
	
	
	
	}
	
}