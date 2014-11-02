package declarative.example1.manager;

import declarative.example1.beans.Customer;
import declarative.example1.dao.CustomerDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tomasz on 02.11.14.
 */
public class CustomerManagerImpl implements CustomerManager {

    private CustomerDao customerDao;

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
