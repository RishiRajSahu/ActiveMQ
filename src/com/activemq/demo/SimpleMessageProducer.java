package com.activemq.demo;

import java.util.Date;

import javax.jms.JMSException;

import org.springframework.jms.core.JmsTemplate;
public class SimpleMessageProducer {

    private JmsTemplate jmsTemplate; 
    private int numberOfMessages = 100; 

    public void sendMessages() throws JMSException {
		System.out.println("inside SimpleMessageProducer" + jmsTemplate);
        StringBuilder payload = null;
        for (int i = 0; i < numberOfMessages; ++i) {
            payload = new StringBuilder(); 
            payload.append("Message [").append(i).append("] sent at: ").append(new Date());
    		jmsTemplate.convertAndSend(payload.toString());
            System.out.println("Sending message number [" + i + "]");
        }
    }
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}

