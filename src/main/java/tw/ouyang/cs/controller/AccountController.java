package tw.ouyang.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import tw.ouyang.cs.model.Account;
import tw.ouyang.cs.service.AccountService;

@CrossOrigin
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/account/{customerId}")
	public Flux<Account> getAccountsByCustomerId(@PathVariable String customerId) {
		return accountService.getAccountsByCustomerId(customerId);
	}

}
