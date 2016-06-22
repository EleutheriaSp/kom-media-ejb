package pl.kommedia.serwer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.kommedia.dao.administracja.FirmyDao;
import pl.kommedia.sprzedaz.dao.FakturyBil;

@ApplicationScoped
public class Zasoby {

	@Produces
	@PersistenceContext
	private EntityManager em;
	
	@Produces
	private FirmyDao daoFirma(){
		return new FirmyDao( em);
	}
	
	@Produces
	private FakturyBil daoFaktury(){
		return new FakturyBil( em);
	}
}
