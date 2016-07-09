package pl.kommedia.ejb.sprzedaz;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;

import pl.kompro.model.handel.Faktury;

@Stateful
@Remote( Faktury.class)
public class FakturySprzedazy implements Faktury, Serializable{
	private static final long serialVersionUID = 7533384892410181194L;

	@Override public KryteriaFaktury odbKryteriaFaktury(){
		return new KryteriaFakturySprzedazy(); //faktury.odbKryteriaFaktury());
	}


}
