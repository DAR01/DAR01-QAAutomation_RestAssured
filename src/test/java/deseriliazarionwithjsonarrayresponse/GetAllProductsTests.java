package deseriliazarionwithjsonarrayresponse;



import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProductsTests {
	
	
	@Test
	public void getAllProductsAPITest() {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		
	Response response = given()
		//.header("Authoriziaton", "Bearer c5ea850e987f307a7bf0574724a407ebf5a0b8c794f1a9ad498383e6bbc49978")
		.when()
			.get("/products");
			
	response.prettyPrint();
	
	ObjectMapper mapper = new ObjectMapper();
	try{//json arrays as response ---> User.class
		Product [] product =  mapper.readValue(response.getBody().asString(), Product[].class);
		
		for(Product p : product) {
			System.out.println("id :" + p.getId());
			System.out.println("Title :" + p.getTitle());
			System.out.println("Description :" + p.getDescription());
			System.out.println("Price :" + p.getPrice());
			System.out.println("Category :" + p.getCategory());
			System.out.println("Image :" + p.getImage());
			
			System.out.println("rate :" + p.getRating().getRate());
			System.out.println("count :" + p.getRating().getCount());
		}
	}catch(JsonMappingException e) {e.printStackTrace();
	}catch(JsonProcessingException e){e.printStackTrace();
	}
	
	
	
	
	
	
	

}
}