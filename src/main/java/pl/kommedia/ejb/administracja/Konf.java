package pl.kommedia.ejb.administracja;

import java.io.Serializable;
import java.util.List;

import pl.kompro.model.kartoteki.Firma;

public interface Konf extends Serializable{
	public List<Firma> getWykazFirm();
	//public String getWykazFirm();
	public void businessMethod();
	
	//public String getKryteria();
	public KonfKryteria getKryteria();
	
	interface KonfKryteria extends Serializable{
		String odbKryteria();
	}
}
