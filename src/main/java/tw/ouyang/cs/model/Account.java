package tw.ouyang.cs.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT", indexes = @Index(name = "accountIdIndex", columnList = "accountId", unique = true))
public class Account {

	public static Integer SEQUENCE = 1;
	public static Random random = new Random();

	@Id
	private String id;
	private String customerId;
	private String accountId;
	private String currency;
	private String accountOpenDate;

	public void setIdAndAccountIdAutomatically() {
		this.id = String.format("%04d", SEQUENCE++);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append((char) (random.nextInt(26) + 'A'));
		for (int i = 0; i < 9; i++) {
			stringBuilder.append(random.nextInt(10));
		}
		this.accountId = stringBuilder.toString();
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(String creationDate) {
		this.accountOpenDate = creationDate;
	}

}
