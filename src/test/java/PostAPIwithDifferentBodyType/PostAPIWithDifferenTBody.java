package PostAPIwithDifferentBodyType;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class PostAPIWithDifferenTBody {
	
	@Test
	public void bodyWithTest() {
		
		RestAssured.baseURI = "https://postman-echo.com";
		
		String payload = "hi this Angelo here";
		
		given().log().all()
			.contentType(ContentType.TEXT)
				.body(payload)
					.when()
						.post("/post")
							.then().log().all()
								.assertThat()
									.statusCode(200);
		
	}
	
	@Test
	public void bodyWithJavaScriptTest() {
		
		RestAssured.baseURI = "https://postman-echo.com";
		
		String payload = "<script>\n"
				+"document.getElementById(\"demo\").innerHTML=10.50\n"
						+ "</script>";
		
		given().log().all()
			.contentType("application/javascript")
				.body(payload)
					.when()
						.post("/post")
							.then().log().all()
								.assertThat()
									.statusCode(200);
		
	}
	
	
	@Test
	public void bodyWithHTMLTest() {
		
		RestAssured.baseURI = "https://postman-echo.com";
		
		String payload = "<html>\n"
				+"<body>document.getElementById(\"demo\").innerHTML=10.50\n"
						+"</body>\n"
				+"</html>";
		
		given().log().all()
			.contentType(ContentType.HTML)
				.body(payload)
					.when()
						.post("/post")
							.then().log().all()
								.assertThat()
									.statusCode(200);
		
	}

	
	
	
	
	
	
}
