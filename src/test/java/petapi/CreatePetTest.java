package petapi;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import deseriliazarionwithjsonarrayresponse.Product;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petapi.Pet.Tag;
	


public class CreatePetTest {

	@Test
	public void CreateAPetTest() {
		
		RestAssured.baseURI = "https://petstore3.swagger.io/";
		
		Pet.Category category = new Pet.Category(1, "Dog");
		List<String> photoUrls = Arrays.asList("https://ex.com","https://dog.com");
		Pet.Tag tag1 = new Pet.Tag(1,  "Red");
		Pet.Tag tag2 = new Pet.Tag(2,  "Blue");
		List<Tag> tags = Arrays.asList(tag1, tag2);
		
		Pet pet = new Pet(101, "Ronney", "available", category, photoUrls, tags);
		
		
		//pojo to json :::: serialisation will occurs 
	Response response = given().log().all()
			.contentType(ContentType.JSON)
		//.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
			.body(pet)
			.when().log().all()
			.post("/api/v3/pet");
	
	response.prettyPrint();


	//Deserialization: json to pojo:
	
	ObjectMapper mapper = new ObjectMapper();
	try{//json arrays as response ---> User.class
		Pet p =  mapper.readValue(response.getBody().asString(), Pet.class);
		
		//for(Pet p : petRes) {
			System.out.println("id :" + p.getId());
			System.out.println("name :" + p.getName());
			System.out.println("Category :" + p.getCategory().getName());
			System.out.println("Category :" + p.getCategory().getId());

			System.out.println("Tag1 :" + p.getTag().get(1).getId());
			System.out.println("Tag1 :" + p.getTag().get(1).getName());
			
			System.out.println("Status :" + p.getStatus());
			System.out.println("Category :" + p.getPhotoUrls());			
		//}
	}catch(JsonMappingException e) {e.printStackTrace();
	}catch(JsonProcessingException e){e.printStackTrace();
	}
	
	
	
	
	
	
	
	}
	
	
}
