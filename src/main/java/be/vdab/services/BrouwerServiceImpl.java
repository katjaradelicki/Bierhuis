package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
public class BrouwerServiceImpl implements BrouwerService {
	private final BrouwerDAO brouwerDAO;
	@Autowired
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO=brouwerDAO;
	}
public List<Brouwer> findAll(){
	return brouwerDAO.findAll(new Sort("naam"));
}
@Override
public Brouwer find(long id) {
	
	return brouwerDAO.findOne(id);
}
}
