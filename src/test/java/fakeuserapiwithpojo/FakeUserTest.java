package fakeuserapiwithpojo;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import deseriliazarionwithjsonarrayresponse.Product;
import fakeuserapiwithpojo.FakeUser.Address;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FakeUserTest {
	

	@Test
	public void createAFakeUserTest() {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Address.GeoLocation geoLocation = new Address.GeoLocation("-37.3356", "85.911");
		Address address = new Address("Bangalore", "new Road st", 990, "12865-3487", geoLocation);
		FakeUser.Name name = new FakeUser.Name("Revathy", "Verma");
		
		FakeUser fakeUser = new FakeUser("revathy@gmail.com", "revathytest", "test@123","1-123-345-7866", name, address);
		
		
	Integer resId = given().log().all()
		//.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
		.body(fakeUser)
			.when().log().all()
			.post("/users")
				.then()
				.extract().path("id");
			
	System.out.println("Id code of the created resource is : " +resId);
	
//	response.prettyPrint();

}
}
