package pl.kommedia.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup

public class KartotekiWspolne {

	@PostConstruct
    public void businessMethod() {
    	System.err.println( "Dupa x5");
    }
}
