package tw.ouyang.cs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import tw.ouyang.cs.model.Condition;
import tw.ouyang.cs.model.Customer;
import tw.ouyang.cs.repository.CustomerCrudRepository;
import tw.ouyang.cs.repository.CustomerRepository;

@Service
public class CustomerService {

	private Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerCrudRepository customerCrudRepository;

	public Flux<Customer> getAllCustomers() {
		return Flux.fromIterable(customerCrudRepository.findAll());
	}

	public Flux<Customer> getCustomers(Condition condition) {
		condition.setCurrentIndex(condition.getStep() * Integer.parseInt(condition.getRows()));
		return Flux.fromIterable(customerRepository.findCustomers(condition));
	}

	public void addCustomer(Customer customer) {
		customerCrudRepository.save(customer);
		logger.info("[Add Customer] " + customer);
	}

	public void updateCustomer(Customer customer) {
		customer = customerCrudRepository.save(customer);
		logger.info("[Update Customer] " + customer);
	}

	public void deleteCustomer(String id) {
		Customer customer = customerCrudRepository.findById(id).get();
		customerCrudRepository.deleteById(id);
		logger.info("[Delete Customer] " + customer);
	}

}
