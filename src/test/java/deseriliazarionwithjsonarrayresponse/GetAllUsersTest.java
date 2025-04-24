package deseriliazarionwithjsonarrayresponse;



import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class GetAllUsersTest {
	
	@Test
	public void getAllUsersTest() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
	Response response = given()
		.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
		.when()
			.get("/public/v2/users");
			
	response.prettyPrint();
	
	//Deserialization: json -to pojo
	ObjectMapper mapper = new ObjectMapper();
	try{//json arrays as response ---> User.class
		User [] userRes =  mapper.readValue(response.getBody().asString(), User[].class);
		
		for(User user : userRes) {
			System.out.println("id :" + user.getId());
			System.out.println("name :" + user.getName());
			System.out.println("gender :" + user.getGender());
			System.out.println("email :" + user.getEmail());
			System.out.println("Status :" + user.getStatus());
		}
	}catch(JsonMappingException e) {e.printStackTrace();
	}catch(JsonProcessingException e){e.printStackTrace();
	}
	
	
	
	}

}
