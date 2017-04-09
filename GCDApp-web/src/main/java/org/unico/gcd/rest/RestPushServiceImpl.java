package org.unico.gcd.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.unico.gcd.dao.ArgumentDao;
import org.unico.gcd.dao.UserDao;
import org.unico.gcd.domain.Arguments;
import org.unico.gcd.jms.JMSProducer;
import org.unico.gcd.jms.Queues;
import org.unico.gcd.json.JSONMapper;


/**
 * RestPushServiceImpl exposes two GET REST methods push and list.
 * 
 * @author Rohan Dave
 *
 */
@Path("/gcd")
public class RestPushServiceImpl implements RestPushService {

	String name = null;
	@Inject
	ArgumentDao paramsDao;
	
	@Inject
	UserDao userDao;
	
	@Inject
	JMSProducer producer;
	
	@Inject
	JSONMapper jsonMapper;
	
	@Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
	ConnectionFactory jmsConnectionFactory;

	@Inject 
	Queues queues;
	
	Logger logger = LogManager.getLogger(RestPushServiceImpl.class);

	public RestPushServiceImpl() {
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.unico.services.rest.PushService#push(int, int)
	 */
	@GET
	@Path("/push/{param1}/{param2}")
	@Produces("text/plain")
	public String push(@PathParam("param1") int argument1, @PathParam("param2") int argument2) {
	
		logger.debug("\n param1 = " + argument1 + " .. param2 = " + argument2);
		try {
			producer.send(jmsConnectionFactory, queues.getParamQueue(), argument1 + "");
			producer.send(jmsConnectionFactory, queues.getParamQueue(), argument2 + "");
			paramsDao.saveArguments(argument1, argument2);
		} catch (Exception e) {
			e.printStackTrace();
			return "Not able to send input to JMS queue: " + e.getMessage();
		} 
		return "Recieved parameters :" + argument1 + " and " + argument2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.unico.services.rest.PushService#list()
	 */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Integer> getList() {
		List<Integer> retList = new ArrayList<>();
		Collection<Arguments> allSavedItems = paramsDao.getArgumentList();
		for(Arguments params : allSavedItems){
			retList.add(params.getArgument1());
			retList.add(params.getArgument2());
		}
		return retList;
	}
}
