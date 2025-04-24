package GETAPITestWithBDD;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class ContactsAPIsTest {

	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
	}
	
	@Test(priority =1)
	public void getContactsAPITest() {
			
		//Method chaining also called Builder pattern. It is also used in Actions Class in selenium
		
		given().log().all()
			.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2FhMGZkMmNjODI1NzAwMTM5MTViYWIiLCJpYXQiOjE3NDQyMDE0MjR9.QfSiMDbAL5HdMwsJe7oOeRh8h6aQcsAD17bYBpn0OlM")
				.when()
					.get("/contacts")
						.then().log().all()
							.assertThat()
								.statusCode(200)
								.and()
									.contentType(ContentType.JSON);
	}

	@Test(priority =2)
	public void getContactsAPIAuthErroTest() {
		//RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		//Method chaining also called Builder pattern. It is also used in Actions Class in selenium
		
		given().log().all()
			.header("Authorization", "Bearer -Angelo")
				.when()
					.get("/contacts")
						.then().log().all()
							.assertThat()
								.statusCode(401);
	}

	@Test(priority = 3)
	public void getContactsAPIAuthInvalidTokenTest() {
		//RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		//Method chaining also called Builder pattern. It is also used in Actions Class in selenium
		
		String errorMsg = given().log().all()
			.header("Authorization", "Bearer -Angelo")
				.when()
					.get("/contacts")
						.then().log().all()
							.extract()
								.path("error");
					
		
		System.out.println(errorMsg);		
		Assert.assertEquals(errorMsg, "Please authenticate.");
	
	}

	
}
