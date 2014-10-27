package jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.Map;

/**
 * Created by tomasz on 27.10.14.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"context.xml"});

        DataSourceTransactionManager txManager = (DataSourceTransactionManager) ctx.getBean("txManager");
        DefaultTransactionDefinition tDef = new DefaultTransactionDefinition();
        TransactionStatus tStatus = txManager.getTransaction(tDef);
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(txManager.getDataSource());
            jdbcTemplate.execute("INSERT INTO table1(name) VALUES('Transaction completed !');");

        } catch (Exception ex) {
            txManager.rollback(tStatus);
        }
        txManager.commit(tStatus);

        ((AbstractApplicationContext) ctx).registerShutdownHook();
    }
}