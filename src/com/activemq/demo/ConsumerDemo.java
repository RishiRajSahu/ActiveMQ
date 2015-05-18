package com.activemq.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQMessage;

public class ConsumerDemo implements MessageListener {

	public void onMessage(Message message) {
		if (message instanceof ActiveMQMessage) {
			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				String msg = null;
				try {
					msg = tm.getText();
				} catch (JMSException e) {
					e.printStackTrace();
				}
				System.out.println("Processed message = " + msg);
			}
		}
	}
}
