package teste;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import util.resolveUtil;

@ArquillianSuiteDeployment
public class Deployments {

    @Deployment(name = "simples", order = 1)
    @TargetsContainer("app")
    public static Archive<?> createTestArchive()  {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
			;

		    WebArchive war = ShrinkWrap.create(WebArchive.class)
		    	.addClass(Deployments.class)
				.addClass(Teste.class)
			;
		    //resolveUtil.addDependencyPomAsFileInWebArchive(war, "org.slf4j:slf4j-log4j12");
	    	
	    	EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
	    		.addAsModule(jar)
	    		.addAsModule(war)
	    	;  
//	    	ear.addAsManifestResource("jboss-all.xml");
	    	    	
	    	System.out.println(ear.toString(true));
			//System.out.println(ret.toString(false));
	    	return ear;
	    }  

}
