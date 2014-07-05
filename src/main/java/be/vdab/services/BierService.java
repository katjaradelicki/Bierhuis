package be.vdab.services;

import java.util.List;

import be.vdab.entities.Bier;

public interface BierService {
	
	public int findTotaalAantalBieren();
	public List<Bier> findByBrouwer(long brouwerNr);
	public Bier find(long bierNr);
	

}
