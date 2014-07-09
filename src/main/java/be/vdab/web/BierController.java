package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;
import be.vdab.services.BierService;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.BestelbonLijn;


@Controller
@RequestMapping("/bieren")
public class BierController {
	
	private final BierService bierService;
	private final BrouwerService brouwerService;
	
	@Autowired
	public BierController(BierService bierService,BrouwerService brouwerService){
		this.bierService=bierService;
		this.brouwerService=brouwerService;
	}
	
	
	@RequestMapping(params="idBrouwer",method=RequestMethod.GET)
	public ModelAndView toonBierenVanBrouwer(@RequestParam long idBrouwer){
		ModelAndView modelAndView=new ModelAndView("/bieren/bieren","bieren",bierService.findByBrouwer(idBrouwer));
		modelAndView.addObject("gekozenBrouwer", brouwerService.find(idBrouwer));
		return  modelAndView;
		
	}
	
	@RequestMapping(value="/bier",params="idBier",method=RequestMethod.GET)
	public ModelAndView toonDetailBier(@RequestParam long idBier){
		
		Bier gekozenBier=bierService.find(idBier);
		ModelAndView modelAndView=new ModelAndView("/bieren/bier","gekozenBier",gekozenBier);
		BestelbonLijn lijn=new BestelbonLijn();
		lijn.setBier(gekozenBier);//bier van de form al invullen want wordt niet ingevuld via invoervak en bij hashcode() op bestelbonLijn krijg je een nullpointerException (bij validatie) (want je doet bier.hashcode())
		modelAndView.addObject("bestelbonLijn", lijn);
		return  modelAndView;
	}
	

}
