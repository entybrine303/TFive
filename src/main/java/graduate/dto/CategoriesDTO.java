package graduate.dto;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDTO implements Serializable{
	private String categoriesID;
	private String restaurantID;
	private String name;
	private Boolean isEdit = false;

}
