package tw.ouyang.cs.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tw.ouyang.cs.model.Condition;
import tw.ouyang.cs.model.Customer;

@Repository
public class CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Customer> findCustomers(Condition condition) {
		String where = StringUtils.isBlank(condition.getWhere()) ? "" : " WHERE " + condition.getWhere();
		String orderBy = StringUtils.isBlank(condition.getSort()) ? "" : " ORDER BY " + condition.getSort();
		String rows = String.format(" LIMIT %d, %s", condition.getCurrentIndex(), condition.getRows());
		String sqlString = String.format("SELECT id, customer_id, name, sex, age, balance FROM CUSTOMER%s%s%s", where, orderBy, rows);
		return jdbcTemplate.query(sqlString, new BeanPropertyRowMapper<>(Customer.class));
	}

}
