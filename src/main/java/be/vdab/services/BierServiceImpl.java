package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;

@Service
@Transactional(readOnly = true)
public class BierServiceImpl implements BierService{
	BierDAO bierDAO;
	
	@Autowired
	public BierServiceImpl(BierDAO bierDAO){
		this.bierDAO = bierDAO;
	}
	
	@Override
	public List<Bier> findByBrouwerId(long id) {
		return bierDAO.findByBrouwerId(id);
	}


	@Override
	public List<Bier> findByIdIn(Iterable<Long> bierIds) {
		return bierDAO.findAll(bierIds);
	}

	@Override
	public long count() {
		return bierDAO.count();
	}

}
