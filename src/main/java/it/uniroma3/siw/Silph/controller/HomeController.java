package it.uniroma3.siw.Silph.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.Silph.model.Foto;
import it.uniroma3.siw.Silph.model.Richiesta;
import it.uniroma3.siw.Silph.service.FotoService;
import it.uniroma3.siw.Silph.service.RichiestaService;
import it.uniroma3.siw.Silph.service.RichiestaValidator;

@Controller
public class HomeController {

	@Autowired
	private FotoService fotoService;

	@Autowired
	private RichiestaService richiestaService;

	@Autowired
	private RichiestaValidator richiestaValidator;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ultimi15Foto(Model model) {
		model.addAttribute("richiesta", new Richiesta());
		List<Foto> foto = this.fotoService.ultimi15();
		model.addAttribute("fotos", foto);
		return "home";
	}

	@RequestMapping(value = "/login")
	public String linkLogin() {
		return "login";
	}

	@RequestMapping(value = "/formRichiesta", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("richiesta") Richiesta richiesta, 
			Model m, BindingResult bindindResult) {
			this.richiestaValidator.validate(richiesta, bindindResult);
		if (!bindindResult.hasErrors()) {
			
			m.addAttribute("richieste", this.richiestaService.save(richiesta));
			return "okRichiesta";} 
		else {
			return "home";}
		}
	
}
