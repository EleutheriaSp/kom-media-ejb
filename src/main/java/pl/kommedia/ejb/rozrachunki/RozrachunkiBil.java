package pl.kommedia.ejb.rozrachunki;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.inject.Inject;

import pl.kommedia.dao.administracja.FirmyDao;
import pl.kommedia.dao.rozrachunki.BudowniczyRozrachunku;
import pl.kommedia.dao.rozrachunki.RozrachunkiPro;
import pl.kommedia.dao.sprzedaz.FakturyBil;
import pl.kommedia.jpa.rozrachunki.RozrachunekPro;
import pl.kommedia.jpa.sprzedaz.FakturaBil;
import pl.kompro.model.rozrachunki.Rozrachunki;
import pl.kompro.model.rozrachunki.StanRozrachunku;

@Stateful
@Remote( Rozrachunki.class)
public class RozrachunkiBil implements Rozrachunki, Serializable{
	private static final long serialVersionUID = 4121961323786472844L;

	@Inject
	private FirmyDao firmy;
	
	@Inject
	private FakturyBil faktury;
	
	@Inject
	private RozrachunkiPro rozrachunki;
	
	@Override public String utwRozrachunekDlaFaktury( long id){
		FakturaBil faktura= faktury.odbFakture( id);
		RozrachunekPro rozrachunek= faktura.akceptuj( new BudowniczyRozrachunku());
		
		rozrachunek.wstStatus( rozrachunki.odbStatusyRozrachunku().get(0)); // pierwszy możliwy
		rozrachunek.wstStan( StanRozrachunku.Tworzony);
		
		rozrachunek.wstFirme( firmy.odbWykazFirm().get( 0)); // <- poprawic na faktura.odbFirme();
		rozrachunek.wstDzial( faktury.odbDzial( faktura)); // 
		
		rozrachunek.wstKontrahenta( faktura.odbPodmiot());
		if( faktura.czyOdbiorca()){
			rozrachunek.wstPlatnika( faktura.odbOdbiorce().odbPodmiot());
		}else{
			rozrachunek.wstPlatnika( faktura.odbPodmiot());
		}
		
		rozrachunki.utrwal( rozrachunek);
		
		return rozrachunek.toString();
		
	}

}
