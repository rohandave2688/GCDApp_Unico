/**
 * 
 */
package org.unico.gcd.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.unico.gcd.SpringWithJNDIRunner;
import org.unico.gcd.dao.ArgumentDao;
import org.unico.gcd.dao.GCDDao;
import org.unico.gcd.domain.Arguments;
import org.unico.gcd.rest.RestPushService;

/**
 * @author jsingh
 *
 */
@RunWith(SpringWithJNDIRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
public class RestPushServiceImplTest {

	@Autowired
	RestPushService restPushService;
	
	@Autowired
	ArgumentDao paramsDao;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		Collection<Arguments> paramsList = new ArrayList<Arguments>();
		paramsList.add( new Arguments(20, 40));
		paramsList.add( new Arguments(60, 80));
		paramsList.add( new Arguments(80, 90));
		doReturn(paramsList).when(paramsDao).getArgumentList();
	}

	/**
	 * Test method for {@link org.unico.gcd.rest.RestPushServiceImpl#push(int, int)}.
	 */
	@Test
	public void testPush() {
		assertEquals("Recieved parameters :20 and 16",restPushService.push(20, 16));
	}

	/**
	 * Test method for {@link org.unico.gcd.rest.RestPushServiceImpl#getList()}.
	 */
	@Test
	public void testGetList() {
		List<Integer> paramList = restPushService.getList();
		assertEquals(new Integer(20), paramList.get(0));
		assertEquals(new Integer(40), paramList.get(1));
		assertEquals(new Integer(60), paramList.get(2));
		assertEquals(new Integer(80), paramList.get(3));
		assertEquals(new Integer(80), paramList.get(4));
		assertEquals(new Integer(90), paramList.get(5));
		
	}

}
