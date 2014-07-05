package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;

@Service
public class BierServiceImpl implements BierService{
	
	private final BierDAO bierDAO;
	
	@Autowired
	public BierServiceImpl(BierDAO bierDAO){
		this.bierDAO=bierDAO;
	}

	@Override
	public int findTotaalAantalBieren() {
		
		return (int)bierDAO.count();
	}

	@Override
	public List<Bier> findByBrouwer(long brouwerNr) {
		
		return bierDAO.findByBrouwerBrouwerNr(brouwerNr);
	}

	@Override
	public Bier find(long bierNr) {
		
		return bierDAO.findOne(bierNr);
	}

}
