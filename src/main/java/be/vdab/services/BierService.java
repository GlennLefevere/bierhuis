package be.vdab.services;

import java.util.List;

import be.vdab.entities.Bier;

public interface BierService {
	public long count();
	public List<Bier> findByIdIn(Iterable<Long> bierIds);
	List<Bier> findByBrouwerId(long id);
}
