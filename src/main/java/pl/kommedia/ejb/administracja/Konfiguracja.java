package pl.kommedia.ejb.administracja;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.inject.Inject;

import pl.kommedia.dao.administracja.FirmyDao;
import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kommedia.sprzedaz.dao.FakturyBil;
import pl.kompro.model.kartoteki.Firma;

//@Singleton
//@Startup
@Stateful
@Remote( Konf.class)
public class Konfiguracja implements Konf, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -760724601121244087L;
	@Inject
	private FirmyDao firmy;
	
	@Inject
	private FakturyBil faktury;
	
	@PostConstruct
    public void businessMethod() {
    	System.err.println( "Dupa x8: Firma: "+ firmy);
    	System.err.println( "Dupa x8: Faktury: "+ faktury);
    	//for( Firma firma:  getWykazFirm()){
    	//	System.out.println( "Firma: "+ firma.getNazwa());
    	//}
    }
	
	public List<Firma> getWykazFirm(){
		
    	FirmaSpinacz fs= new FirmaSpinacz();
    	for( FirmaApp firma: firmy.odbWykazFirm())
    		fs.add( firma.akceptuj( fs));
		//FirmaSpinacz2 f2= new FirmaSpinacz2();
/*		
		Vector<Firma> fv= new Vector<Firma>();
    	for( FirmaApp firma: firmy.odbWykazFirm()){
    		Firma dupa = firma.akceptuj( fs);
    		System.out.println( "Dupa: "+ dupa);
    		//fv.add( dupa);
    		
    		//fv.add( f2.akceptuj( firma));
    		
    		fv.add( new FirmaSpinacz3());
    	}
*/		
		return fs;	
		
		//firmy.odbWykazFirm();
		//return "Eleutheria Sp. z o.o.";
	}

	@Override
	public KonfKryteria getKryteria() {
		// TODO Auto-generated method stub
		
		return new KonfKryteria() {
			private static final long serialVersionUID = -6740285652815215354L;
			String komunikat= "Dziala...";

			@Override
			public String odbKryteria() {
				// TODO Auto-generated method stub
				return komunikat;
			}
		};
		
		
		//return new KryteriaKonfiguracji();
	}

	
}
