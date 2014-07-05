package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	public List<Brouwer> findAll();
	public Brouwer find(long id);
}
