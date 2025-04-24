package fakeuserapiwithpojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeUser {

//	private Integer Id;
	private String email;
	private String username;
	private String password;
	private String phone;
	
	private Name name;
	private Address address;
	
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Name{
		private String firstname;
		private String lastname;	
	}
	
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Address{
		private String city;
		private String street;
		private Integer number;
		private String zipcode;
		private GeoLocation geoLocation;
	
		@Data
		@Builder
		@AllArgsConstructor
		@NoArgsConstructor
		public static class GeoLocation{
			private String lat;
			@JsonProperty("long")
			private String longitude;	
		}
	
	
	}	
	
	
	
	
	
}


