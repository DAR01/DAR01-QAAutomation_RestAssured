import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CreateUserWithLombokTest {
	
	
	
	private String getRandwomEmailId() {
		return "apitestautomation"+System.currentTimeMillis()+"@open.com";
	}
	
	@Test
	public void addUserWithLombokTest() {
	
		RestAssured.baseURI = "https://gorest.co.in";
	
	UserLombok user = new UserLombok("seema", getRandwomEmailId(), "active", "female");
	
	
	Integer userId = given().log().all()
						.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
						.contentType(ContentType.JSON)
						.body(user)
						.when()
						.post("/public/v2/users")
					.then().log().all()
					.statusCode(201)
					.extract()
					.path("id");
	
	System.out.println("userId" + userId);
	}
	

}
					

