package be.vdab.web;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	private static final String BEVESTIGD_VIEW = "/winkelwagen/bevestigd";
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
		Map<Long, Integer> mandjes = mandje.getMandje();
		if (!mandjes.isEmpty()) {
			List<Bier> bieren = bierService.findByIdIn(mandjes.keySet());
			for (Bier bier : bieren) {
				mand.add(new Bestelbonlijn(bier, mandjes.get(bier.getId())));
			}
		}
		return mand;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/bestellen")
	ModelAndView wegschrijven(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
		bestelbon.setBestelbonlijnen(vanMandjeNaarBestelbonlijnen());
		if (!bindingResult.hasErrors() && bestelbon.getBestelbonlijnen().size() > 0) {
			Bestelbon verstuurdeBestelbon = bestelbonService.create(bestelbon);
			mandje.clear();
			return new ModelAndView(BEVESTIGD_VIEW).addObject("id", verstuurdeBestelbon.getId());
		}
		return new ModelAndView(WINKELWAGEN_VIEW).addObject(bestelbon);
	}
}
