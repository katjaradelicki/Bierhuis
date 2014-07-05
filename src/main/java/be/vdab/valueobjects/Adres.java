package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Adres implements Serializable{
	private static final long serialVersionUID=1L;
	
	@Size(min=1,max=50,message="{Size.tekst}")
	String straat;
	@Size(min=1,max=50,message="{Size.tekst}")
	String huisNr;
	@Column(name="postCode")
	@NotNull
	@Min(1000)
	@Max(9999)
	Integer postcode;
	@Size(min=1,max=50,message="{Size.tekst}")
	String gemeente;
	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}
	
	public Adres() { //voor JPA
		//moet public zijn (en niet protected) om in je jsp het volgende te doen: <form:label path="adres.straat">Straat</form:label>
		
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
	
	
	

}
