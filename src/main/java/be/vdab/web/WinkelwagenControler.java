package be.vdab.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bier;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.Bestelbonlijn;

@Controller
@RequestMapping("/winkelwagen")
public class WinkelwagenControler {
	private static final String WINKELWAGEN_VIEW = "/winkelwagen/winkelwagen";
	private Mandje mandje;
	private BierService bierService;
	private BestelbonService bestelbonService;

	@Autowired
	public WinkelwagenControler(Mandje mandje, BierService bierService, BestelbonService bestelbonService) {
		this.mandje = mandje;
		this.bestelbonService = bestelbonService;
		this.bierService = bierService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView overzicht() {
		Bestelbon bestelbon = new Bestelbon();
		bestelbon.setBestelbonlijnen(vanMandjeNaarBestelbonlijnen());
		return new ModelAndView(WINKELWAGEN_VIEW).addObject(bestelbon);
	}

	private Set<Bestelbonlijn> vanMandjeNaarBestelbonlijnen() {
		Set<Bestelbonlijn> mand = new HashSet<>();
		List<Long> bierenIds = new ArrayList<Long>();
		List<Bier> bieren = new ArrayList<>();
		Map<Long, Integer> mandjes = mandje.getMandje();
		for (Entry<Long, Integer> entry : mandjes.entrySet()) {
			bierenIds.add(entry.getKey());
		}
		if (!bierenIds.isEmpty()) {
			bieren = bierService.findByIdIn(bierenIds);
		}
		for (Bier bier : bieren) {
			mand.add(new Bestelbonlijn(bier, mandjes.get(bier.getId())));
		}
		return mand;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/bestellen")
	ModelAndView wegschrijven(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			Bestelbon verstuurdeBestelbon = bestelbonService.create(bestelbon);
			System.out.println(verstuurdeBestelbon.getId());
		}
		return new ModelAndView(WINKELWAGEN_VIEW).addObject(bestelbon);
	}
}
