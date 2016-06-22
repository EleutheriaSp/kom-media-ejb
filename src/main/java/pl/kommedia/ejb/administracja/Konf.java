package pl.kommedia.ejb.administracja;

import java.util.List;

import pl.kompro.model.kartoteki.Firma;

public interface Konf{
	public List<Firma> getWykazFirm();
	//public String getWykazFirm();
	public void businessMethod();
}
