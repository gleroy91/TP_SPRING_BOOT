package ensg.eu.TPSpring.Controller;

import java.util.ArrayList;
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
import ensg.eu.TPSpring.services.ParticipantRepository;

@Controller
public class ParticipantController {
	
	@Autowired
	private ParticipantRepository participantRepository;
	@Autowired
	private EvenementRepository evenementRepository;
	
	@GetMapping("/liste_participants")
	public String listeParticipants(Model model) {
		
		// Affichage des evenements
		model.addAttribute("listeEvenements", evenementRepository.findAll());
		model.addAttribute("listeParticipants", participantRepository.findAll());
		return "liste_participants";
	}
	
	
	  @GetMapping("/gerer_participants") 
	  public String gererParticipants(Model model) {
	  
	  // Ajout de données au modèle 
		 model.addAttribute("listeEvenements",evenementRepository.findAll()); model.addAttribute("listeParticipants",
	  participantRepository.findAll());
	  
	  // Affichage des evenements
	return "gerer_participants"; }
	 
	
	@GetMapping("/ajout_participant")
	public String ajoutParticipant(
			@RequestParam(name="nom", required=true) String nom, 
			@RequestParam(name="prenom", required=true) String prenom, 
			@RequestParam(name="email", required=true) String email, 
			@RequestParam(name="date_naiss", required=true) String date_naiss, 
			@RequestParam(name="evenement", defaultValue = "")List<String> listeId, 
			Model model) {
		
		// Sauvegarde du nouveau participant dans la base de données
		String[] date = date_naiss.split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		Participant newParticipant = new Participant(nom, prenom, email, new Date(year, month, day));
		for (String id : listeId) {
			Optional<Evenement> evenement = evenementRepository.findById(Integer.parseInt(id));
			if (!evenement.isEmpty()) {
				newParticipant.evenements.add(evenement.get());
			}
		}
		participantRepository.save(newParticipant);
		
		// Affichage des participants mis à jour
		model.addAttribute("listeEvenements", evenementRepository.findAll());
		model.addAttribute("listeParticipants", participantRepository.findAll());
		return "gerer_participants";
	}
	
	
}
