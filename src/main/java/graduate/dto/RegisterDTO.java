package graduate.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO implements Serializable{
	private String username;
	private String password;
	private String confirmPassword;
	private String role;
}