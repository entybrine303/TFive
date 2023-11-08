package graduate.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart implements Serializable{
	@Id
	@Column(length = 10)
	private String cartID;
	private Integer quantity;
	private Double totalAmount;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date savedDate;
	
	@PrePersist
    public void prePersist() {
        Calendar calendar = Calendar.getInstance();
        savedDate = calendar.getTime();
    }

	@ManyToOne
	@JoinColumn(name = "dishID", referencedColumnName = "dishID")
	private Dish dish ;
	@ManyToOne
	@JoinColumn(name = "customerID", referencedColumnName = "customerID")
	private Customer customer;
}
