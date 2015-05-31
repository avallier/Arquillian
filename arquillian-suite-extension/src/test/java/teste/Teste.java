package teste;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class Teste {

    @Test
    @OperateOnDeployment("simples")
    public void teste()	{
    	//sucesso
    }

}
