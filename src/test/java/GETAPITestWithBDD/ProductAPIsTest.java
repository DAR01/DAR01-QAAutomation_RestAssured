package GETAPITestWithBDD;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductAPIsTest {

//	https://fakestoreapi.com/docs

	@Test
	public void getProductsTest() {
		RestAssured.baseURI = "https://fakestoreapi.com";

		Response response = given().when().get("/products");

		System.out.println("status code: " + response.statusCode());
		System.out.println("statuc line: " + response.statusLine());

		response.prettyPrint();

		JsonPath js = response.jsonPath();

		List<Integer> productIdList = js.getList("id");
		System.out.println(productIdList);

		List<Float> productPriceList = js.getList("price");
		System.out.println(productPriceList);

		List<Float> productRateList = js.getList("rating.rate");
		System.out.println(productRateList);

		List<Integer> productCountList = js.getList("rating.count");
		System.out.println(productCountList);
		
		for(int i=0; i<productIdList.size(); i++) {
			int id = productIdList.get(i);
			Float productPrice = productPriceList.get(i);
			//double productRateList = productRateList.get(i);
			int count = productCountList.get(i);
			
			System.out.println("Id: " + id + "price: " + productPrice + "count: " + count);
		}

	}

}
