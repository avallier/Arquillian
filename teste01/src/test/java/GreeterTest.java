
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class GreeterTest {

    @Deployment
    public static JavaArchive createDeployment() {    
    	JavaArchive jar = 
    			ShrinkWrap.create(JavaArchive.class)
    			.addClass(Greeter.class)
    			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
    	;
    	System.out.println(jar.toString(true));
    	return jar;
    }
	
    @Inject
    Greeter greeter;

    @Test
	public void testGreet() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCreateGreeting() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void should_create_greeting() {
	    Assert.assertEquals("Hello, Earthling!",
	        greeter.createGreeting("Earthling"));
	    greeter.greet(System.out, "Earthling");
	}

}
