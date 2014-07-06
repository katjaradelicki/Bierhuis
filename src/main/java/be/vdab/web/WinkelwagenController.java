package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;

@Controller
@RequestMapping("/winkelwagen")
public class WinkelwagenController {
	
	private final BierService bierService;
	private final BestelbonService bestelbonService;
	private Winkelwagen winkelwagenOnSession;
	@Autowired
	public WinkelwagenController(BierService bierService,BestelbonService bestelbonService,Winkelwagen winkelwagen){
		this.bierService= bierService;
		this.winkelwagenOnSession=winkelwagen;
		this.bestelbonService=bestelbonService;
	}
	
	@RequestMapping(method=RequestMethod.POST,params="idBier")
	public ModelAndView voegBestelLijnToe(@Valid BestelbonLijn bestelbonLijn,BindingResult bindingResult, @RequestParam long idBier){
		System.out.println("requestmapping method voegBestelLijnToe en bindingResult: "+bindingResult.getAllErrors().toString());
		System.out.println("*************************de form bestelbonLijn: "+bestelbonLijn);
		if(!bindingResult.hasErrors()){
			int aantal=bestelbonLijn.getAantal();
			long bierNr=bestelbonLijn.getBier().getBierNr();
			System.out.println("******************* bierNr: "+bierNr + " en bier is "+bestelbonLijn.getBier());
			BestelbonLijn lijn=new BestelbonLijn(bierService.find(idBier), aantal);
			if(winkelwagenOnSession.getBestelbon()==null){//winkelwagenOnSession <> null
				winkelwagenOnSession.setBestelbon(new Bestelbon());
			}
			winkelwagenOnSession.getBestelbon().addBestelbonLijn(lijn);
			return new ModelAndView("redirect:/winkelwagen/overzicht");//gaat dat: ModelAndView ipv String? Blijkbaar wel. Maar request attributen bij een redirect wel anders toevoegen dan via ModelAndView.
		}else{
		
			ModelAndView modelAndView=new ModelAndView("/bieren/bier","gekozenBier",bierService.find(idBier));
			return modelAndView;
		}
		
	}
	@RequestMapping(value="/overzicht",method=RequestMethod.GET)
	public ModelAndView toonOverzicht(){
		//sessie ook rechtstreeks aanspreken in jsp? ${not empty sessionScope.winkelwagenOnSession.bestelbon.bestelbonLijnen} werkt niet. winkelwagenOnSession is leeg
		ModelAndView modelAndView=new ModelAndView("/winkelwagen/overzicht","winkelwagen",winkelwagenOnSession);
		modelAndView.addObject("bestelbon", new Bestelbon());
		return modelAndView;
	}
	
	@RequestMapping(value="/overzicht",method=RequestMethod.POST)
	//@Transactional
	public String verwerkBestelbon(@Valid Bestelbon bestelbon,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		//bestelbon in db opslaan
		//mandje van sessie halen
		//transactie van maken?
		if(!bindingResult.hasErrors()){ 
		String naam=bestelbon.getNaam();
		String straat=bestelbon.getAdres().getStraat();
		String huisNr=bestelbon.getAdres().getHuisNr();
		Integer postcode=bestelbon.getAdres().getPostcode();
		String gemeente=bestelbon.getAdres().getGemeente();
		Bestelbon bestelbonToCreate=winkelwagenOnSession.getBestelbon();//bestelbonLijnen zijn ingevuld
		bestelbonToCreate.setNaam(naam);
		bestelbonToCreate.setAdres(new Adres(straat,huisNr,postcode,gemeente));
		
		bestelbonService.create(bestelbonToCreate);
		winkelwagenOnSession.setBestelbon(null);//sessie bean te verwijderen? dan kan je het niet hercreëren dus niet verwijderen
		//bestelbonNr nog doorgeven 
		redirectAttributes.addAttribute("bestelbonNr", bestelbonToCreate.getBestelbonNr());
		return "redirect:/winkelwagen/besteld";
		}else {
			return "winkelwagen/overzicht";
		}
	}
	
	@RequestMapping(value="/besteld",method=RequestMethod.GET,params="bestelbonNr")
	public String toonBevestiging(){
		 
		return "/winkelwagen/besteld";
	}
	
	@InitBinder("bestelbon")
	public void initBinderBestelbon(DataBinder dataBinder){
		
		//dataBinder.setRequiredFields("naam","adres.straat","adres.huisNr","adres.postcode","adres.gemeente");//vervangen door bean validation
		
	}
	
}
