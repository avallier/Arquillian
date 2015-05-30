package greeter.arquillian.suite.extension;

import greeter.Greeter;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterTest extends Deployments {

    @Inject
    Greeter greeter;

    @Test
    @OperateOnDeployment("normal")
	public void should_create_greeting() {
		Assert.assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));
		greeter.greet(System.out, "Earthling");
	}

}
