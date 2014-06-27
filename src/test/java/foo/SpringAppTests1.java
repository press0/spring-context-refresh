package foo;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringAppTests1 {

    @Autowired HelloService helloService;
    @Autowired String string;

    @Test
    public void testSayHello() {

        Assert.assertEquals("Hello world!", helloService.sayHello());

        Assert.assertEquals("foo", string);
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring-config2.xml");
        ((ConfigurableApplicationContext) ctx).refresh();
        string = ctx.getBean(String.class);
        Assert.assertEquals("bar", string);


    }
}
