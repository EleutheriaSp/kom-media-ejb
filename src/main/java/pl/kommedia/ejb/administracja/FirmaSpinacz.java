package pl.kommedia.ejb.administracja;

import java.util.Vector;

import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kommedia.jpa.administracja.OdwiedzajacyFirmeApp;
import pl.kompro.model.kartoteki.Firma;

public class FirmaSpinacz extends Vector<Firma> implements OdwiedzajacyFirmeApp<Firma>{
	private static final long serialVersionUID = -6593091443043273870L;

	@Override public Firma odwiedz( FirmaApp firma){
		return new Firma(){
			private String kod;
			private String nazwa;
			{
				kod= firma.odbKod();
				nazwa= firma.odbNazwe();
			}
			
			@Override public String getKod(){
				return kod;
			}

			@Override public String getNazwa(){
				return nazwa;
			}
		};
	}
}
