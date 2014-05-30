package pizzashop;

import java.net.URL;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Order {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long number;

	@Persistent
	private String shohin_name;

	@Persistent
	private String price;

	@Persistent
	private Date datetime;

	public Order(String shohin_name, String price, Date datetime) {
		super();
		this.shohin_name = shohin_name;
		this.price = price;
		this.datetime = datetime;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getShohin_Name() {
		return shohin_name;
	}

	public void setShohin_Name(String shohin_name) {
		this.shohin_name = shohin_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}