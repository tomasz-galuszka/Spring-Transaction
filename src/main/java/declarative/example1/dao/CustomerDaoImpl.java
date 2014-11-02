package declarative.example1.dao;

import declarative.example1.beans.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by tomasz on 02.11.14.
 */
public class CustomerDaoImpl implements CustomerDao {

    private DataSource dataSource;

    @Override
    public void create(Customer customer) {
        String queryCustomer = "insert into customer (name) values (?)";
        String queryAddress = "insert into address (address,country) values (?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(queryCustomer, new Object[] {customer.getName()});
        jdbcTemplate.update(queryAddress, new Object[] {customer.getAddress().getAddress(), customer.getAddress().getCountry()});
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
