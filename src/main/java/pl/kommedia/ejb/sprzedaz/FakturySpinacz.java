package pl.kommedia.ejb.sprzedaz;

import java.util.Vector;

import pl.kommedia.sprzedaz.dao.OdwiedzajacyFaktureBil;
import pl.kommedia.sprzedaz.jpa.FakturaPodstawowaBil;
import pl.kompro.model.handel.Faktura;

public class FakturySpinacz extends Vector<Faktura> implements OdwiedzajacyFaktureBil<Faktura>{
	private static final long serialVersionUID = -3686291500865244917L;

	@Override public Faktura odwiedz( final FakturaPodstawowaBil faktura){
		return new Faktura(){
			private static final long serialVersionUID = 1245077919861283613L;

			private String numer;
			{
				numer= faktura.odbNumer();
			}
			
			@Override public String getNumer(){
				return numer;
			}
			
		};
	}


}
