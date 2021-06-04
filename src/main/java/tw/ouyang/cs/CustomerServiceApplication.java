package tw.ouyang.cs;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import tw.ouyang.cs.model.Customer;
import tw.ouyang.cs.repository.CustomerCrudRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner runner(CustomerCrudRepository customerRepository) {
		Faker faker = new Faker();
		return args -> {
			for (int i = 1; i <= 200; i++) {
				Customer customer = new Customer();
				customer.setIdAndCustomerIdAutomatically();
				customer.setName(faker.name().fullName());
				customer.setSex(getSex());
				customer.setAge((int) (Math.random() * 68) + 18);
				customer.setBalance(new BigDecimal((int) (Math.random() * 1000000)));
				customerRepository.save(customer);
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

}
