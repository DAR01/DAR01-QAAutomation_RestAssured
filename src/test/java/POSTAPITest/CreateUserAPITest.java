package POSTAPITest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class CreateUserAPITest {
	
	@Test
	public void createUserWithJSONStringTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		given()
			.header("Authorization", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
				.contentType(ContentType.JSON)
					.body("{\n"
							+ "    \"name\": \"Navemn\",\r\n"
							+ "    \"email\": \"angveenqqaaqq@muller.example\",\r\n"
							+ "    \"gender\": \"female\",\r\n"
							+ "    \"status\": \"active\"\r\n"
							+ "}")
					.when()
						.post("/public/v2/users")
							.then().log().all()
								.assertThat()
									.statusCode(201);
		
	}
	
//	@Test
//	public void createUserWithJSONFileTest() {
//		RestAssured.baseURI = "https://gorest.co.in";
//		
//		given().log().all()
//			.header("Authorization", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
//				.contentType(ContentType.JSON)
//					.body(new File("./src/test/resources/jsons/user.json"))
//					.when()
//						.post("/public/v2/users")
//							.then()
//								.assertThat()
//									.statusCode(201);
//		
//	}

}
