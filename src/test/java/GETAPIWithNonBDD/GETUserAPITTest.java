package GETAPIWithNonBDD;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETUserAPITTest {
	
	
	
	@Test 
	public void getContactsTest() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2FhMGZkMmNjODI1NzAwMTM5MTViYWIiLCJpYXQiOjE3NDQyOTU3NTN9.3EBQDvq44KN8LFT8AL0du-2VtT134aYfSHDgBz--U10");
		Response response = request.get("/contacts");
		
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		
		response.prettyPrint();
		String contentType = response.header("content-type");
		System.out.println(contentType);
		
		Headers headers = response.headers();
		
		List<Header> headerList = headers.asList();
		System.out.println(headerList.size());
		
		for(Header e: headerList) {
			String name = e.getName();
			String value = e.getValue();
			System.out.println(name + ":" + value);
		}
		
	}

}
