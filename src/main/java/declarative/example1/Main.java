package declarative.example1;

import declarative.example1.beans.Address;
import declarative.example1.beans.Customer;
import declarative.example1.manager.CustomerManagerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tomasz on 02.11.14.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("context-example1.xml");
        CustomerManagerImpl customerManager = (CustomerManagerImpl) ctx.getBean("customerManager");
        Customer customer = createDummyCustomer();
        customerManager.createCustomer(customer);


        ((AbstractApplicationContext) ctx).registerShutdownHook();

    }

    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setName("123456789123456789011"); // 21 length , table has restriction to 20
        Address address = new Address();
        address.setCountry("Poland");
        address.setAddress("Rynek 1 31-800 Cracow");
        customer.setAddress(address);
        return customer;
    }
}
