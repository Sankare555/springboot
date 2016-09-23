package message.sender;

import hello.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import javax.annotation.ManagedBean;
import javax.jms.*;
import java.io.Serializable;
import java.util.List;

@Service
@ManagedResource(objectName = "spring:name=JMSSenderTemplate", description = "JMSSenderTemplate")
public class JMSSenderTemplate implements Runnable{

    @Autowired
    private JmsTemplate jmsTemplate;

    private MessageConsumer consumer;

    public void send(final String text) {

        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Destination defaultDestination = jmsTemplate.getDefaultDestination();
                consumer = session.createConsumer(defaultDestination);
                Message message = session.createTextMessage(text);
                message.setJMSReplyTo(defaultDestination);
                return message;
            }
        });

        TextMessage textMessage= (TextMessage) jmsTemplate.receive(jmsTemplate.getDefaultDestination());
        try {
            System.out.println(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            send("Message_" + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
