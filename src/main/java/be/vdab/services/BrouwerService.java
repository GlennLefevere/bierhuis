package be.vdab.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	public Page<Brouwer> findAll(Pageable pageable);
}
