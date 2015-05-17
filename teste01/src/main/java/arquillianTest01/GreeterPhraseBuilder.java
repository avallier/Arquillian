package arquillianTest01;

import java.io.PrintStream;
import javax.inject.Inject;

public class GreeterPhraseBuilder {

    private PhraseBuilder phraseBuilder;

    @Inject
    public GreeterPhraseBuilder(PhraseBuilder phraseBuilder) {
        this.phraseBuilder = phraseBuilder;
    }

    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return phraseBuilder.buildPhrase("hello", name);
    }
	
}
