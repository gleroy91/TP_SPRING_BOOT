package ensg.eu.TPSpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccueilController {
	
	@GetMapping("/accueil")
	//public String accueil(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	public String accueil(){
		// Ajout de données au modèle
		//model.addAttribute("name", name);
		
		//Envoi vers la vue
		return "accueil";
	}
}