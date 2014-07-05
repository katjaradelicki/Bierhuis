package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="bieren")
public class Bier implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long bierNr;
	private String naam;
	@ManyToOne
	@JoinColumn(name="BrouwerNr")
	private Brouwer brouwer;
	@ManyToOne
	@JoinColumn(name="SoortNr")
	private Soort soort;
	@Column(name="Alcohol")
	@NumberFormat(style=Style.PERCENT)//scheiding van view en data????
	private BigDecimal percentageAlcohol;
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal prijs;
	@Override
	public int hashCode() {
		
		return naam.hashCode()+brouwer.hashCode()+soort.hashCode()+percentageAlcohol.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bier other = (Bier) obj;
		if (brouwer == null) {
			if (other.brouwer != null)
				return false;
		} else if (!brouwer.equals(other.brouwer))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (percentageAlcohol == null) {
			if (other.percentageAlcohol != null)
				return false;
		} else if (!percentageAlcohol.equals(other.percentageAlcohol))
			return false;
		if (soort == null) {
			if (other.soort != null)
				return false;
		} else if (!soort.equals(other.soort))
			return false;
		return true;
	}
	public long getBierNr() {
		return bierNr;
	}
	public String getNaam() {
		return naam;
	}
	public Brouwer getBrouwer() {
		return brouwer;
	}
	public Soort getSoort() {
		return soort;
	}
	public BigDecimal getPercentageAlcohol() {
		return percentageAlcohol;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public void setBrouwer(Brouwer brouwer) {
		this.brouwer = brouwer;
	}
	public void setSoort(Soort soort) {
		this.soort = soort;
	}
	public void setPercentageAlcohol(BigDecimal percentageAlcohol) {
		this.percentageAlcohol = percentageAlcohol;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	
	@Override
	public String toString() {
		
		return this.naam+"("+brouwer+","+soort+","+prijs+","+percentageAlcohol+")";
	}
	
	

}
