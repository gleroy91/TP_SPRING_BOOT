package ensg.eu.TPSpring.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ensg.eu.TPSpring.metier.Evenement;
import ensg.eu.TPSpring.metier.Participant;
import ensg.eu.TPSpring.services.EvenementRepository;

@Controller
public class EvenementController {
	
	@Autowired
	private EvenementRepository evenementRepository;
	
	@GetMapping("/liste_evenements")
	public String listeEvenements(Model model) {
		
		// Affichage de la liste des evenements 
		model.addAttribute("listeEvenements", evenementRepository.findAll());
		return "liste_evenements";
	}
	
	
	  @GetMapping("/gerer_evenements") public String gererEvenements(Model
	  model) {
	  
		// Affichage de la liste des evenements 
	  model.addAttribute("listeEvenements",evenementRepository.findAll());
	  return "gerer_evenements"; }
	 
	
	@GetMapping("/ajout_evenement")
	public String ajoutEvenement(
			@RequestParam(name="intitule", required=true) String intitule, 
			@RequestParam(name="date_debut", required=true) String date_debut, 
			Model model) {
		
		// Sauvegarde du nouvel evenement dans la BDD
		String[] date = date_debut.split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		Evenement newEvenement = new Evenement(intitule, new Date(year, month, day));
		evenementRepository.save(newEvenement);
		
		//Affichage de la liste des evenements mis à jour
		model.addAttribute("listeEvenements", evenementRepository.findAll());
		return "gerer_evenements";
	}
	
	
}