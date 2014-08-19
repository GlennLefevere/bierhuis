package be.vdab.entities;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "brouwers")
public class Brouwer {
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty
	private String naam;
	@NotEmpty
	private String straat;
	@NotEmpty
	private String huisNr;
	private int postcode;
	@NotEmpty
	private String gemeente;
	private Integer omzet;
	@OneToMany(mappedBy="brouwer")
	private Set<Bier> bieren;
	
	public Set<Bier> getBieren() {
		return Collections.unmodifiableSet(bieren);
	}

	public void setBieren(Set<Bier> bieren) {
		this.bieren = bieren;
	}

	public Brouwer(){}

	public Brouwer(long id, String naam, String straat, String huisNr, int postcode, String gemeente, int omzet) {
		this.id = id;
		this.naam = naam;
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
		this.omzet = omzet;
	}
	
	public String getNaam() {
		return naam;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Brouwer [id=" + id + ", naam=" + naam + ", straat=" + straat + ", huisNr=" + huisNr + ", postcode=" + postcode + ", gemeente=" + gemeente + ", omzet=" + omzet + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente == null) ? 0 : gemeente.toLowerCase().hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.toLowerCase().hashCode());
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
		Brouwer other = (Brouwer) obj;
		if (gemeente == null) {
			if (other.gemeente != null)
				return false;
		} else if (!gemeente.equalsIgnoreCase(other.gemeente))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equalsIgnoreCase(other.naam))
			return false;
		return true;
	}
	
}
