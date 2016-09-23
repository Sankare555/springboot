package message.sender;

import hello.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by sankarge on 22-Sep-16.
 */
public class JMSMessageSender {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms-sender.xml");
        JMSSenderTemplate jMSSenderTemplate = ctx.getBean("JMSSenderTemplate", JMSSenderTemplate.class);
        jMSSenderTemplate.run();
    }
}
