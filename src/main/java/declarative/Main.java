package declarative;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tomasz on 30.10.14.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"context-declarative.xml"});

        FooService fooService = (FooService) ctx.getBean("fooService");
        Foo foo = fooService.getFoo(1);

        ((AbstractApplicationContext)ctx).registerShutdownHook();
    }
}
