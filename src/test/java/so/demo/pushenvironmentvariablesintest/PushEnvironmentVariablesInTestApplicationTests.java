package so.demo.pushenvironmentvariablesintest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(properties = { "bar = foo" , "foobar = foobar"} )
class PushEnvironmentVariablesInTestApplicationTests {


	static {
		System.setProperty("foo","bar");
	}

	@Autowired Environment environment;

	@Test
	void loadEnvironmentVariables() {
		assertNotNull(environment);
		assertEquals("bar" , environment.getProperty("foo"));
		assertEquals("foo" , environment.getProperty("bar"));
		assertEquals("foobar" , environment.getProperty("foobar"));
	}

}
