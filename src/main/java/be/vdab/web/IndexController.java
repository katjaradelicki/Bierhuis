package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;

@Controller
public class IndexController {
	 private final BierService bierService;
	 
	 @Autowired
	 public IndexController(BierService bierService){
		 this.bierService=bierService;
	 }
	
	
	@RequestMapping("/")
	public ModelAndView index(){
		
		return new ModelAndView("welkom","aantalBieren",bierService.findTotaalAantalBieren());
	}
}
