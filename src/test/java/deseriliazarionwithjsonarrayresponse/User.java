package deseriliazarionwithjsonarrayresponse;

//import groovy.transform.builder.Builder;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

		private Integer id;
		private String name;
		private String email;
		private String gender;
		private String status;
}
