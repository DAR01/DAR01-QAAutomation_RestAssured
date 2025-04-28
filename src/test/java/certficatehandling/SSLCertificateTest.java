package certficatehandling;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

public class SSLCertificateTest {
	
	@Test
	public void sslTest() {
		RestAssured.given()
		.relaxedHTTPSValidation() //allows to ignore the ssl validation
		.when()
			.get("https://untrusted-root.badssl.com")
			.then()
			.assertThat().statusCode(200);

		}
	
	@Test
	public void sslWithConfigTest() {
		RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		
		RestAssured.given()
		.when()
			.get("https://untrusted-root.badssl.com")
			.then()
			.assertThat().statusCode(200);
	}

}
