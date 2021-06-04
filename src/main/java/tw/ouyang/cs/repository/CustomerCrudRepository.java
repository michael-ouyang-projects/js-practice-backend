package tw.ouyang.cs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.ouyang.cs.model.Customer;

@Repository
public interface CustomerCrudRepository extends CrudRepository<Customer, String> {

}
