package graduate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voucher")
public class Voucher implements Serializable{
	@Id
	@Column(length = 10)
	private String voucherID;
	private String description;
	private String img;
	private double reducedPrice;
	private double minimumPrice;
	private boolean isShare;
	private boolean VoucherType;
	
	@ManyToOne
	@JoinColumn(name = "restaurantID", referencedColumnName = "restaurantID")
	private Restaurant restaurant;

	@OneToOne(mappedBy = "voucher")
    private Order order;
}
