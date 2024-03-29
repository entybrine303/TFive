package graduate.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "orderDetail")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailID;
	private Integer quantity;
	private Double totalAmount;
	
	@ManyToOne
	@JoinColumn(name = "dishID", referencedColumnName = "dishID")
	private Dish dish ;
	
	@ManyToOne
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    private Order orders;
}
