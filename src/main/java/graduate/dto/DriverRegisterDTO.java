package graduate.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverRegisterDTO implements Serializable {
	private String name;
	private String email;
	private String phoneNumber;
	private String identificationCard;
}
