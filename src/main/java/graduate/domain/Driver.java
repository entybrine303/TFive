package graduate.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver implements Serializable{
	@Id
	@Column(length = 10)
	private String driverID;
	@Column(length = 10)
	private String licensePlates;
	@Column(length = 50, columnDefinition = "nvarchar(100)")
	private String name;
	private Boolean sex;
	@Column(length = 10)
	private String phoneNumber;
	private String email;
	private String motorbike;
	private Boolean workStatus;
	@Column(length = 12)
	private String identificationCard;
	private String img;

	@OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Order> orders;
	
	@OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Account account;

	
}
