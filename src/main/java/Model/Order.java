package Model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	private int orderId;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Account account;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Car car;
	
	public Order() {
		super();
	}
	
	public Order(int orderId, Account account, Car car) {
		super();
		this.orderId = orderId;
		this.account = account;
		this.car = car;
	}
	
	public Order(Account account, Car car) {
		super();
		this.account = account;
		this.car = car;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", account=" + account + ", car=" + car + "]";
	}
	
}
