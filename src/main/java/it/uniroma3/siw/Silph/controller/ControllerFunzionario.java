package it.uniroma3.siw.Silph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.Silph.model.Foto;
import it.uniroma3.siw.Silph.model.Fotografo;
import it.uniroma3.siw.Silph.service.FotoService;
import it.uniroma3.siw.Silph.service.FotografoService;
import it.uniroma3.siw.Silph.service.RichiestaService;

@Controller
public class ControllerFunzionario {
	@Autowired
	private FotoService fotoService;
	
	@Autowired
	private RichiestaService richiestaService;

	@Autowired
	private FotografoService fotografoService;
	
	@RequestMapping("/linkRichieste")
	public String linkRichieste(Model model) {
		model.addAttribute("richieste", this.richiestaService.tutteRichieste());
		return "listaRichieste";
	}

	@RequestMapping("/funzionario")
	public String indexFunzionario() {
		return "indexFunzionario";
	}

	@RequestMapping("/linkinserisciFotografo")
	public String UploadPage(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "registraFotografo";
	}

	@RequestMapping("/logout")
	public String esci(Model model) {
		List<Foto> foto = this.fotoService.ultimi15();
		model.addAttribute("fotos", foto);
		return "home";
	}

	@RequestMapping("/Home")
	public String home(Model m) {
		return "indexFunzionario";
	}

	@RequestMapping(value = "/deleteFotografo/{id}", method = RequestMethod.POST)
	public String eliminaFotografo(@PathVariable("id") Long id, Model model) {
		if (id != null) {
			this.fotografoService.eliminaFotografoPerID(id);
			model.addAttribute("fotografi", this.fotografoService.tuttiFotografi());
			return "listaFotografi";
		} else {
			return "okAlbum";
		}
	}

}
