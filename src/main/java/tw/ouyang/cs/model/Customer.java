package tw.ouyang.cs.model;

import java.math.BigDecimal;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER", indexes = @Index(name = "customerIdIndex", columnList = "customerId", unique = true))
public class Customer {

	public static Integer SEQUENCE = 1;
	public static Random random = new Random();

	@Id
	private String id;
	private String customerId;
	private String name;
	private String sex;
	private Integer age;
	private BigDecimal balance;

	@Override
	public String toString() {
		return String.format("id: %s, customerId: %s, name: %s, sex: %s, age: %d, balance: %d", this.getId(),
				this.customerId, this.name, this.sex, this.age, this.balance.intValue());
	}

	public void setIdAndCustomerIdAutomatically() {
		this.id = String.format("%04d", SEQUENCE++);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append((char) (random.nextInt(26) + 'A'));
		for (int i = 0; i < 9; i++) {
			stringBuilder.append(random.nextInt(10));
		}
		this.customerId = stringBuilder.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
