package be.vdab.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import be.vdab.valueobjects.Bestelbonlijn;

@Entity
@Table(name="bestelbonnen")
public class Bestelbon {
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty
	@Length(min=1, max = 50)
	private String naam;
	@NotEmpty
	@Length(min=1, max = 50)
	private String straat;
	@NotEmpty
	@Length(min=1, max = 50)
	private String huisNr;
	@Range(min=1000, max = 9999)
	private int postcode;
	@NotEmpty
	@Length(min=1, max = 50)
	private String gemeente;
	@ElementCollection
	@CollectionTable(name="bestelbonlijnen", joinColumns = @JoinColumn (name="bestelbonid"))
	private Set<Bestelbonlijn> bestelbonlijnen;
	
	public Bestelbon() {
	}

	public Bestelbon(long id, String naam, String straat, String huisNr, int postcode, String gemeente) {
		this.id = id;
		this.naam = naam;
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public int getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
	public Set<Bestelbonlijn> getBestelbonlijnen() {
		return bestelbonlijnen;
	}

	public void setBestelbonlijnen(Set<Bestelbonlijn> bestelbonlijnen) {
		this.bestelbonlijnen = bestelbonlijnen;
	}

	public BigDecimal getTotaal(){
		BigDecimal totaal = BigDecimal.ZERO;
		for (Bestelbonlijn bestelbonlijn : bestelbonlijnen) {
			BigDecimal temp = totaal.add(bestelbonlijn.getTeBetalen());
			totaal = temp;
		}
		return totaal;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente == null) ? 0 : gemeente.hashCode());
		result = prime * result + ((huisNr == null) ? 0 : huisNr.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result + ((straat == null) ? 0 : straat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestelbon other = (Bestelbon) obj;
		if (gemeente == null) {
			if (other.gemeente != null)
				return false;
		} else if (!gemeente.equals(other.gemeente))
			return false;
		if (huisNr == null) {
			if (other.huisNr != null)
				return false;
		} else if (!huisNr.equals(other.huisNr))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (straat == null) {
			if (other.straat != null)
				return false;
		} else if (!straat.equals(other.straat))
			return false;
		return true;
	}
	
}
