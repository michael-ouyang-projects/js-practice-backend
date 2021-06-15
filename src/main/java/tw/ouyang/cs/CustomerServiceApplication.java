package tw.ouyang.cs;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import tw.ouyang.cs.model.Account;
import tw.ouyang.cs.model.Customer;
import tw.ouyang.cs.repository.AccountCrudRepository;
import tw.ouyang.cs.repository.CustomerCrudRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	private static Faker faker = new Faker();
	private static Calendar calendarA = Calendar.getInstance();
	private static Calendar calendarB = Calendar.getInstance();
	private static SimpleDateFormat taiwaneseDateFormat = new SimpleDateFormat("yyyy/MM/dd");

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner runner(CustomerCrudRepository customerCrudRepository,
			AccountCrudRepository accountCrudRepository) {
		calendarA.set(1985, 1, 1);
		calendarB.set(2021, 6, 10);
		return args -> {
			for (int i = 1; i <= 524; i++) {
				Customer customer = new Customer();
				customer.setIdAndCustomerIdAutomatically();
				customer.setName(faker.name().fullName());
				customer.setSex(getSex());
				customer.setAge((int) (Math.random() * 68) + 18);
				customer.setBalance(new BigDecimal((int) (Math.random() * 1000000)));
				customer = customerCrudRepository.save(customer);

				for (int j = 1; j <= 2; j++) {
					Account account = new Account();
					account.setIdAndAccountIdAutomatically();
					account.setCustomerId(customer.getCustomerId());
					account.setCurrency(getCurrency());
					Date fakeDate = faker.date().between(calendarA.getTime(), calendarB.getTime());
					account.setAccountOpenDate(taiwaneseDateFormat.format(fakeDate));
					accountCrudRepository.save(account);
				}
			}
		};
	}

	private String getSex() {
		if ((int) (Math.random() * 2) == 0) {
			return "male";
		} else {
			return "female";
		}
	}

	private String getCurrency() {
		switch ((int) (Math.random() * 3)) {
		case 0:
			return "TWD";
		case 1:
			return "USD";
		case 2:
			return "JPY";
		default:
			return "TWD";
		}
	}

}
