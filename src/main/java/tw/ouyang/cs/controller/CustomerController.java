package tw.ouyang.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import tw.ouyang.cs.model.Condition;
import tw.ouyang.cs.model.Customer;
import tw.ouyang.cs.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public Flux<Customer> getCustomers(@RequestBody Condition condition) {
		return customerService.getCustomers(condition);
	}

	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer customer) {
		customer.setIdAndCustomerIdAutomatically();
		customerService.addCustomer(customer);
	}

	@PutMapping("/customer")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);
	}

}
