package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.vdab.entities.Bier;

@Embeddable
public class BestelbonLijn implements Serializable{
	private static final long serialVersionUID=1L;
	@ManyToOne
	@JoinColumn(name="BierNr")
	private Bier bier;
	private Integer aantal; //Integer van gemaakt ipv int om zo een leeg invoervak te verkrijgen (null) ipv 0 in het invoervak
	
	public BestelbonLijn(){ //voor JPA en  om BestelbonLijn als command object te gebruiken
		
	}

	public Bier getBier() {
		return bier;
	}

	public Integer getAantal() {
		return aantal;
	}

	public void setBier(Bier bier) {
		this.bier = bier;
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}
	
	public BestelbonLijn(Bier bier, int aantal){
		this.bier=bier;
		this.aantal=aantal;
	}

	@Override
	public int hashCode() {
		
		return bier.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BestelbonLijn other = (BestelbonLijn) obj;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return bier+":"+aantal;
	}
	
	public BigDecimal getKostBestelbonLijn(){
		return (bier.getPrijs()).multiply(new BigDecimal(aantal.toString()));
	}
	
	
}
