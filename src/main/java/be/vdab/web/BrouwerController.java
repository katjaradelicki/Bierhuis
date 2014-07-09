package be.vdab.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
@SessionAttributes("bestelbon")
public class BrouwerController {
	 private final BrouwerService brouwerService;
	 
	 @Autowired
	 public BrouwerController(BrouwerService brouwerService){
		 this.brouwerService=brouwerService;
	 }
	
	
	@RequestMapping
	public ModelAndView findAll(){
		
		return  new ModelAndView("brouwers/brouwers","brouwers",brouwerService.findAll());
	}

}
