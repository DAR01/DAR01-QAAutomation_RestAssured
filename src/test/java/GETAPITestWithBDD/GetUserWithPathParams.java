package GETAPITestWithBDD;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class GetUserWithPathParams {
	
	@DataProvider
	public Object [][] getUserData() {
		return new Object[][] {
			{7820539, "Vobis absconditus libero qui aequitas."},
			{7820530, "Harum vehems consecteur sulum ater cumqe."},
			{7820520, "Saepe tabula varietas tamdiu et recusandae su"}
		};
		
	}
	
	@Test(dataProvider = "getUserData")
	public void getUserPostWithPathParamTest(int userId, String title) {
		
		RestAssured.baseURI = "https://gorest.co.in";
		//Map<String, String> userQueryMap = new HashMap<String,String>();
//		userQueryMap.put("status", "active");
//		userQueryMap.put("name", "naveen");
//		userQueryMap.put("gender", "male");
		
		given().log().all()
		.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
			.pathParam("userId", userId)
				.when()
					.get("/public/v2/user/{userId}/posts")
						.then().log().all()
							.assertThat()
								.and()
									.body("name", hasItem(title));

									
	}

	
	
	
	
	@Test
	public void getSingleUserTest() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		//Map<String, String> userQueryMap = new HashMap<String,String>();
//		userQueryMap.put("status", "active");
//		userQueryMap.put("name", "naveen");
//		userQueryMap.put("gender", "male");
		
		given().log().all()
		.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
			.pathParam("userId", 7820532)
				.when()
					.get("/public/v2/user/{userId}/posts")
						.then().log().all()
							.assertThat()
								.and()
									.body("name", hasItem("Asha Mishra CPA"));

	
	
	}						
}
