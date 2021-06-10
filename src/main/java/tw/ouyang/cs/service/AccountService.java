package tw.ouyang.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import tw.ouyang.cs.model.Account;
import tw.ouyang.cs.repository.AccountCrudRepository;

@Service
public class AccountService {

	@Autowired
	private AccountCrudRepository accountCrudRepository;

	public Flux<Account> getAccountsByCustomerId(String customerId) {
		return Flux.fromIterable(accountCrudRepository.findByCustomerId(customerId));
	}

}
