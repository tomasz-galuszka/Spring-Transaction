package hibernate;

import hibernate.beans.Table1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by tomasz on 27.10.14.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"context.xml"});
        HibernateTransactionManager tManager = (HibernateTransactionManager) ctx.getBean("txManager2");

        DefaultTransactionDefinition tDef = new DefaultTransactionDefinition();
        TransactionStatus tStatus = tManager.getTransaction(tDef);
        try {

            HibernateTemplate hibernateTemplate = new HibernateTemplate(tManager.getSessionFactory());
            Table1 test1 = new Table1();
            test1.setName("Hibernate transaction completed !");
            hibernateTemplate.save(test1);

        } catch (Exception e) {
            tManager.rollback(tStatus);
        }
        tManager.commit(tStatus);

        ((AbstractApplicationContext) ctx).registerShutdownHook();
    }
}
