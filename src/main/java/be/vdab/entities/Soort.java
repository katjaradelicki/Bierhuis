package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="soorten")
public class Soort implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue
	private long soortNr;
	private String naam;
	
	
	
	
	
	
	public long getSoortNr() {
		return soortNr;
	}
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
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
		Soort other = (Soort) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
	

}
