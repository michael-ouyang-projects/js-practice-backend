package tw.ouyang.cs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.ouyang.cs.model.Account;

@Repository
public interface AccountCrudRepository extends CrudRepository<Account, String> {

	public List<Account> findByCustomerId(String customerId);

}
