package org.unico.gcd.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;


public class JMSProducer {

	/**
	 * Convenient method to post messages to JMS Queue
	 * @param jmsConnectionFactory
	 * @param queue
	 * @param param
	 */
	public void send(ConnectionFactory jmsConnectionFactory, Queue queue, String param) {
		JMSContext context = null;
		try {
			context = jmsConnectionFactory.createContext();
			context.start();
			context.createProducer().send(queue, param);
		} finally {
			if(context != null) {
				context.close();
			}
		}
	}
}
