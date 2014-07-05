package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name="brouwers")
public class Brouwer implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long brouwerNr;
	private String naam;
	@Embedded
	private Adres adres;
	private Integer omzet;
	
	
	
	
	
	
	public long getBrouwerNr() {
		return brouwerNr;
	}
	public String getNaam() {
		return naam;
	}
	public Adres getAdres() {
		return adres;
	}
	public int getOmzet() {
		return omzet;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	public void setOmzet(int omzet) {
		this.omzet = omzet;
	}
	@Override
	public int hashCode() {
		
		return naam.hashCode();
	} 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brouwer other = (Brouwer) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return naam;
	}
	

}
