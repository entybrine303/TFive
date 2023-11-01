package graduate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driverRegisterForm")
public class DriverRegister implements Serializable{
	@Id
	@Column(length = 10)
	private String phoneNumber;
	private String name;
	private String email;
	@Column(length = 12)
	private String identificationCard;
}
