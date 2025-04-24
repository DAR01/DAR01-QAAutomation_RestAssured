package GETAPITestWithBDD;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class GetUserWithQueryParams {

	@Test
	public void getSingleUserTest() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		Map<String, String> userQueryMap = new HashMap<String,String>();
		userQueryMap.put("status", "active");
		userQueryMap.put("name", "naveen");
		userQueryMap.put("gender", "male");
		
				given().log().all()
					.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
						.queryParams(userQueryMap)
					.queryParam("status", "active")
						.when()
							.get("/public/v2/users")
								.then().log().all()
									.assertThat()
										.statusCode(200)
											.and()
												.contentType(ContentType.JSON);
	}
}
