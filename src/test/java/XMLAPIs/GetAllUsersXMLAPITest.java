package XMLAPIs;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllUsersXMLAPITest {

	@Test
	public void getAllUsersTest() {
		RestAssured.baseURI = "https://gorest.co.in";

		Response response = given()
				.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
				.when()
				.get("/public/v2/users.xml");

		String responseBody = response.getBody().asString();

//create the object XmPath
		XmlPath xmlPath = new XmlPath(responseBody);

//fecthing the data
		String objType = xmlPath.getString("objects.@type");
		System.out.println(objType);
		Assert.assertEquals(objType, "array");

		System.out.println("-------");

		List<String> idList = xmlPath.getList("objects.object.id.@type");
		System.out.println(idList);

		for (String e : idList) {
			System.out.println(e);
			Assert.assertEquals(e, "integer");
		}
		System.out.println("-------");

		// fecth all the id valuse/text
		xmlPath.getList("\"objects.object.id");

	}




@Test
public void getAllUserTestWithXml_Deserialization() {
	RestAssured.baseURI = "https://gorest.co.in";

	Response response = given()
			.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
			.when()
			.get("/public/v2/users.xml");

	String responseBody = response.getBody().asString();
//xml--->pojo:deserialization:
	
	XmlMapper mapper = new XmlMapper();
	
	try {UserData userData = mapper.readValue(responseBody, UserData.class);
	
			System.out.println("id is :" + userData.getObjects().get(0).getId().getValue());
			
			
	}catch(JsonProcessingException e) {
				e.printStackTrace();
			}
	
	
	
}
}