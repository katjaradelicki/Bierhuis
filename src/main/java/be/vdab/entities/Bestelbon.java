package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;

@Entity
@Table(name="bestelbonnen")
public class Bestelbon implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long bestelbonNr;	
	@ElementCollection
	@CollectionTable(name="bestelbonlijnen",joinColumns= @JoinColumn(name="BonNr"))
	@OrderBy("bier.naam") //als je lijnen uit de databank zou lezen dan zijn ze gesorteerd op bier.naam?
	private Set<BestelbonLijn> bestelbonLijnen;
	@Size(min=1,max=50,message="{Size.tekst}")
	@NotNull
	private String naam;
	@Embedded
	@Valid
	private Adres adres;
	
	public Bestelbon(){
		bestelbonLijnen=new HashSet<>();
	}
	
	
	public Set<BestelbonLijn> getBestelbonLijnen() {
		return Collections.unmodifiableSet(bestelbonLijnen);
	}
	public String getNaam() {
		return naam;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setBestelbonLijnen(Set<BestelbonLijn> bestelbonLijnen) {
		this.bestelbonLijnen = bestelbonLijnen;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	public long getBestelbonNr() {
		return bestelbonNr;
	}
	
	public void addBestelbonLijn(BestelbonLijn lijn){
		
		if(bestelbonLijnen.contains(lijn)){
			BestelbonLijn teVerangenLijn=null;
			BestelbonLijn nieuweLijn=null;
			
			for(BestelbonLijn oudeLijn:bestelbonLijnen){
				if(oudeLijn.equals(lijn)){
					nieuweLijn=new BestelbonLijn(oudeLijn.getBier(), oudeLijn.getAantal()+lijn.getAantal());
					//bestelbonLijnen.remove(oudeLijn);//verzameling overlopen en ondertussen elementen verwijderen en toevoegen in gevaarlijk--> buiten de lus doen
					//bestelbonLijnen.add(nieuweLijn);
					teVerangenLijn=oudeLijn;
					
				}
			}
			bestelbonLijnen.remove(teVerangenLijn);
			bestelbonLijnen.add(nieuweLijn);
		}else{
			bestelbonLijnen.add(lijn);
		}
	}
	
	public void removeBestelbonLijn(BestelbonLijn lijn){
		bestelbonLijnen.remove(lijn);
	}
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer("Bestelbon "+bestelbonNr);
		for(BestelbonLijn lijn:bestelbonLijnen){
			buffer.append(" /n "+lijn);
		}
		return buffer.toString();
	}
	
	public BigDecimal getTotaleKost(){
		BigDecimal totaal=BigDecimal.ZERO;
		for(BestelbonLijn lijn:bestelbonLijnen){
			totaal=totaal.add(lijn.getKostBestelbonLijn());
		}
		return totaal.setScale(0, RoundingMode.HALF_UP);
	}
	
}
