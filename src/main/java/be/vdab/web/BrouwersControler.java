package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
public class BrouwersControler {
	private static final String BROUWERS_VIEW = "/brouwers/brouwers";
	private static final String BROUWER_VIEW = "/brouwers/brouwer";
	private BrouwerService brouwerService;

	@Autowired
	public BrouwersControler(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView find(Pageable pageable){
		return new ModelAndView(BROUWERS_VIEW).addObject("page", brouwerService.findAll(pageable));
	}
	
	@RequestMapping(value = "{brouwer}")
	ModelAndView bierenVanBrouwer(@PathVariable Brouwer brouwer){
		return new ModelAndView(BROUWER_VIEW).addObject(brouwer);
	}
}
