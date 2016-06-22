package pl.kommedia.ejb.administracja;

import java.io.Serializable;
import java.util.Vector;

import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kommedia.jpa.administracja.OdwiedzajacyFirmeApp;
import pl.kompro.model.kartoteki.Firma;

public class FirmaSpinacz2 implements Serializable, OdwiedzajacyFirmeApp<Firma>{
	private static final long serialVersionUID = -6257809841018628258L;

	@Override
	public Firma odwiedz( final FirmaApp firma) {
		return new Firma() {
			private String kod= "kod";
			private String nazwa= "nazwa";
			
			@Override public String getNazwa() {
				return nazwa;
			}
			
			@Override public String getKod() {
				return kod;
			}
		};
	}

	public Firma akceptuj( FirmaApp firma) {
		return new Firma() {
			private String kod= "kod";
			private String nazwa= "nazwa";
			
			@Override public String getNazwa() {
				return nazwa;
			}
			
			@Override public String getKod() {
				return kod;
			}
		};
	}

}
