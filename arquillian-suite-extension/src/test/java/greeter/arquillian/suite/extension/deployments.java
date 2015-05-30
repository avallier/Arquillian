package greeter.arquillian.suite.extension;

import greeter.Greeter;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import util.resolveUtil;

@ArquillianSuiteDeployment
public class deployments {

    @Deployment
    //@TargetsContainer("app")
    public static Archive<?> createTestArchive()  {
		JavaArchive jar = ShrinkWrap
			.create(JavaArchive.class)
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
			//.addAsResource("weblogic.xml")
		;

	    WebArchive war = ShrinkWrap
			//.create(WebArchive.class, "test.war")
	    	.create(WebArchive.class)
			.addClass(Greeter.class)
			.addClass(GreeterTest.class)
		;
    	//resolveUtil.addDependencyPomAsFileInWebArchive(war, "br.com.avallier:arquillian:0.0.1-SNAPSHOT");
    	
    	EnterpriseArchive ret = ShrinkWrap.create(EnterpriseArchive.class)
    		.addAsModule(jar)
    		.addAsModule(war)
    		//.as(EnterpriseArchive.class)
    	;  
    	    	
    	System.out.println(ret.toString(true));
		//System.out.println(ret.toString(false));
    	return ret;
    }	
	
}
