package XMLAPIs;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "MRData", namespace = "http://ergast.com/mrd/1.5")
public class MRData {

	@JacksonXmlProperty(isAttribute = true)
	public String series;
	
	@JacksonXmlProperty(isAttribute = true)
	public String url;
	
	@JacksonXmlProperty(isAttribute = true)
	public String limit;
	
	@JacksonXmlProperty(isAttribute = true)
	public String total;
	
	@JacksonXmlProperty(isAttribute = true)
	public String offset;
	
	private CircuitTable circuitTable;
	
	@Data
	public static class CircuitTable{
	
		private String season;
		
		@JacksonXmlElementWrapper(useWrapping = false)
		@JacksonXmlProperty(localName= "Circuit")
		private List<Circuit> circuits;
		
		@Data
		public static class Circuit{
			
			@JacksonXmlProperty(isAttribute = true)
			private String circuitId;
			
			@JacksonXmlProperty(isAttribute = true)
			private String url;
			
			@JacksonXmlProperty(localName = "CircuitName")
			private String circuitName;
			
			@JacksonXmlProperty(localName = "Locality")			
			private Location location;
			
			@Data
			public static class Location{
				@JacksonXmlProperty(isAttribute = true, localName = "lat")
				private String latitude;
				
				@JacksonXmlProperty(isAttribute = true, localName = "long")
				private String longitude;
				@JacksonXmlProperty(localName = "Country")
				private String locality;
				
				@JacksonXmlProperty(localName = "Locality")
				private String country;
			}
		}
		
	}
	
}