package org.unico.gcd.json;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.unico.gcd.SpringWithJNDIRunner;
import org.unico.gcd.domain.Arguments;
import org.unico.gcd.json.JSONMapper;

@RunWith(SpringWithJNDIRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
public class JacksonJSONMapperTest {

	@Autowired
	JSONMapper jsonMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testToJsonString() {
		try {
			assertEquals("{\"id\":0,\"argument1\":25,\"argument2\":50}", jsonMapper.toJsonString(new Arguments(25, 50)));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
