package message.receiver;

import hello.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.Serializable;

@Service
public class JMSListenerTemplate implements SessionAwareMessageListener<TextMessage>{

    @Autowired
    PersonService personService;

    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        MessageProducer replyToMessageProducer = session.createProducer(textMessage.getJMSReplyTo());
        System.out.println(textMessage);
        personService.list();
        TextMessage textMessage1= session.createTextMessage(personService.list().toString());
        replyToMessageProducer.send(textMessage.getJMSReplyTo(), textMessage1);
    }
}
