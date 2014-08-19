package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;
import be.vdab.services.BierService;

@Controller
@RequestMapping("/bier")
public class BierControler {
	private static final String BIER_VIEW = "/bier/bier";
	private final static String REDIRECT_NA_TOEVOEGEN = "redirect:/winkelwagen";
	private Mandje mandje;
	@Autowired
	public BierControler(Mandje mandje) {
		this.mandje = mandje;
	}
	
	@RequestMapping(value = "{bier}")
	ModelAndView findBier(@PathVariable Bier bier){
		return new ModelAndView(BIER_VIEW).addObject(bier).addObject(new BierForm());
	}
	
	@RequestMapping(method = RequestMethod.POST, value="{bier}/toevoegen", params= {"aantal"})
	ModelAndView create(@PathVariable Bier bier, @Valid BierForm bierForm, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			mandje.addItem(bier.getId(), bierForm.getAantal());
			return new ModelAndView(REDIRECT_NA_TOEVOEGEN);
		}
		return new ModelAndView(BIER_VIEW).addObject(bier);
	}

}
