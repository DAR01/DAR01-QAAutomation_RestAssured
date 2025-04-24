package petapi;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import groovy.transform.builder.Builder;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
	
	private Integer id;
	private String name;
	private String status;
	private Category category;
	private List<String> photoUrls;
	private List<Tag> tag;
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor	
	public static class Category{
		private Integer id;
		private String name;		
	}
	
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Tag{
		private Integer id;
		private String name;
	}
	

	
	
	
}
