package graduate.dto;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO implements Serializable{
	private String username;
	private String password;
	private String role;
}
