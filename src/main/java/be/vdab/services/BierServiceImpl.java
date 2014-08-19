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
	public long count() {
		return bierDAO.count();
	}


	@Override
	public List<Bier> findByBrouwerId(long id) {
		return bierDAO.findByBrouwerId(id);
	}


	@Override
	public List<Bier> findByIdIn(List<Long> bierIds) {
		return bierDAO.findByIdIn(bierIds);
	}


	@Override
	public Bier findBier(long id) {
		return bierDAO.findBier(id);
	}

}
