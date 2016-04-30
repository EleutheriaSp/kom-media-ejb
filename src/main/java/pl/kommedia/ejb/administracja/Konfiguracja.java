package pl.kommedia.ejb.administracja;

import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import pl.kommedia.dao.administracja.FirmyDao;
import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kompro.model.kartoteki.Firma;

@Singleton
@Startup

public class Konfiguracja {
	@Inject
	private FirmyDao firmy;
	
	@PostConstruct
    public void businessMethod() {
    	System.err.println( "Dupa x7");
    	for( Firma firma:  getWykazFirm()){
    		System.out.println( "Firma: "+ firma.getNazwa());
    	}
    }
	
	public List<Firma> getWykazFirm(){
    	FirmaSpinacz fs= new FirmaSpinacz();
    	for( FirmaApp firma: firmy.odbWykazFirm())
    		fs.add( firma.akceptuj( fs));
		return fs;	
	}
	
}
