package marsa.maroc.GestionNavires.web;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import marsa.maroc.GestionNavires.dao.GrueRepository;
import marsa.maroc.GestionNavires.dao.NavireRepository;
import marsa.maroc.GestionNavires.entities.Grue;
import marsa.maroc.GestionNavires.entities.Navire;

@Controller
public class NavireController {
	@Autowired
	private NavireRepository navireRepository;
	@Autowired
	private GrueRepository grueRepository;
	@GetMapping(path = "/main")
	public String afficherNavires(Model model) {
		List<Navire> navires = navireRepository.findAll();
		model.addAttribute("navires",navires);
		return "main";
	}
	@GetMapping(path = "/grues")
	public String affichergrues(Model model) {
		List<Grue> grues = grueRepository.findAll();
		model.addAttribute("grues",grues);
		return "grues";
	}
	@SuppressWarnings("null")
	@GetMapping(path = "/addNavire")
	public String addNavire(Model model) {
		int i=0;
		LinkedList<Grue> grues = new LinkedList<Grue>();
		for(Grue g:grueRepository.findAll()) {
			if(g.isTravail()==false) {
				grues.add(g);
				if(i++ == 1) break;
			}
		}
		model.addAttribute("grues",grues);
		model.addAttribute("navire",new Navire());
		return "addNavire";
	}
	@PostMapping("/saveNavire")
	public String saveNavire(Model model,@Valid Navire navire, BindingResult bindingResult) {
		int i=0;
		if(bindingResult.hasErrors()) return "addNavire";
		LinkedList<Grue> grues = new LinkedList<Grue>();
		for(Grue g:grueRepository.findAll()) {
			if(g.isTravail()==false) {
				grues.add(g);
				if(i++ == 1) break;
			}	
		}
		navire.setGrues(grues);
		for(Grue g : grues) {
			g.setNavire(navire);
			g.setTravail(true);
		}
		navireRepository.save(navire);
		model.addAttribute("navire",navire);
		model.addAttribute("grues",grues);
		return "redirect:/main";
		
	}
	@GetMapping(path="/deleteNavire")
	public String delete(Model model,long id) {
		for(Grue g : navireRepository.getById(id).getGrues()) {
			g.setNavire(null);
			g.setTravail(false);
		}
		navireRepository.deleteById(id);
		model.addAttribute("navireRepository",navireRepository);
		return "redirect:/main";
	}
}
