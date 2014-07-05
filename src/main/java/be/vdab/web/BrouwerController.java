package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
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
