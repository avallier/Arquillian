package greeter;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

public class GreeterTest {

	Greeter greeter = new Greeter();

	@Test
	public void should_create_greeting() {
		Assert.assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));
		greeter.greet(System.out, "Earthling");
	}

}
