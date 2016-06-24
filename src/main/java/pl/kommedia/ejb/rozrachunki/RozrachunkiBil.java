package pl.kommedia.ejb.rozrachunki;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import pl.kompro.model.rozrachunki.Rozrachunki;

@Stateful
@Remote( Rozrachunki.class)
public class RozrachunkiBil implements Rozrachunki, Serializable{
	private static final long serialVersionUID = 4121961323786472844L;

	@Override public String utwRozrachunek( long faktura){
		return "Ok.";
		
	}

}
