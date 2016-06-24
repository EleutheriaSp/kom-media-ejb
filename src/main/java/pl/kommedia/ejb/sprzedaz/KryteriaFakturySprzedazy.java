package pl.kommedia.ejb.sprzedaz;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.inject.Inject;

import pl.kommedia.dao.administracja.FirmyDao;
import pl.kommedia.sprzedaz.dao.FakturyBil;
import pl.kommedia.sprzedaz.dao.FakturyBil.KryteriaFakturyBil;
import pl.kommedia.sprzedaz.jpa.FakturaBil;
import pl.kompro.model.handel.Faktura;
import pl.kompro.model.handel.Faktury.KryteriaFaktury;

@Stateful
@Remote( KryteriaFaktury.class)
public class KryteriaFakturySprzedazy implements KryteriaFaktury{
	private static final long serialVersionUID = -4644795309130391658L;

	@Inject
	private FirmyDao firmy;
	
	@Inject
	private FakturyBil faktury;
	
	private KryteriaFakturyBil kryteria;
	
	@PostConstruct
    public void inicjalizuj(){
		kryteria= faktury.odbKryteriaFaktury();
    }

	@Override public List<Faktura> odbFaktury(){
		FakturySpinacz fs= new FakturySpinacz();
		for( FakturaBil faktura: kryteria.odbFaktury())
			fs.add( faktura.akceptuj( fs));
		return fs;
	}

	@Override
	public EnumSet<ZakresFaktur> odbZakresFaktur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public void wstPlatnika( long platnik){
		//faktury.odbKryteriaFaktury();
		
		//kryteria.wstPlatnika( platnik);
	}

}
