package graduate.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(length = 10)
	private String orderDetailID;
	private int quantity;
	private double totalAmount;
	
	@ManyToOne
	@JoinColumn(name = "dishID", referencedColumnName = "dishID")
	private Dish dish ;
	
	@OneToOne
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    private Order orders;
}
