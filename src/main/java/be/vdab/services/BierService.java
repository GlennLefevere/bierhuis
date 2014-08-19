package be.vdab.services;

import java.util.List;

import be.vdab.entities.Bier;

public interface BierService {
	public long count();
	public List<Bier> findByBrouwerId(long id);
	public List<Bier> findByIdIn(List<Long> bierIds);
	public Bier findBier(long id);
}
