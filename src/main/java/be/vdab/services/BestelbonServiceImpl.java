package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BestelbonDAO;
import be.vdab.entities.Bestelbon;

@Service
@Transactional(readOnly = true)
public class BestelbonServiceImpl implements BestelbonService {
	private BestelbonDAO bestelbonDAO;

	@Autowired
	public BestelbonServiceImpl(BestelbonDAO bestelbonDAO) {
		this.bestelbonDAO = bestelbonDAO;
	}

	@Override
	public Bestelbon create(Bestelbon bestelbon) {
		return bestelbonDAO.save(bestelbon);
	}

}
