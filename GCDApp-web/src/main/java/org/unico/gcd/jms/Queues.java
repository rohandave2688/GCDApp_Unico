package org.unico.gcd.jms;

import javax.annotation.Resource;
import javax.jms.Queue;

public class Queues {
	
	@Resource(lookup = "queue/UnicoJMS")
	private Queue paramQueue;

	/**
	 * @return
	 */
	public Queue getParamQueue() {
		return paramQueue;
	}

	/**
	 * @param paramQueue
	 */
	public void setParamQueue(Queue paramQueue) {
		this.paramQueue = paramQueue;
	}

	
}
