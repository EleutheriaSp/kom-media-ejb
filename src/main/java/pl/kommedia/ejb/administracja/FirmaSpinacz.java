package pl.kommedia.ejb.administracja;

import java.io.Serializable;
import java.util.Vector;

import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kommedia.jpa.administracja.OdwiedzajacyFirmeApp;
import pl.kompro.model.kartoteki.Firma;

public class FirmaSpinacz extends Vector<Firma> implements OdwiedzajacyFirmeApp<Firma>, Serializable{
	private static final long serialVersionUID = -6593091443043273870L;


	@Override public Firma odwiedz( final FirmaApp firma){
		return new Firma(){
			private static final long serialVersionUID = 5359748620514150686L;

			private String kod;
			private String nazwa;
			{
				kod= "kod"; //firma.odbKod();
				nazwa= "nazwa"; //firma.odbNazwe();
			}
			
			@Override public String getKod(){
				return kod+ " <test><2>";
			}

			@Override public String getNazwa(){
				return nazwa+ " <test><2>";
			}
		};
	}
}
