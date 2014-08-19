package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "bieren")
public class Bier {
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty
	private String naam;
	private BigDecimal alcohol;
	private BigDecimal prijs;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="brouwerid")
	private Brouwer brouwer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="soortid")
	private Soort soort;
	public Bier() {
	}
	public Bier(String naam, BigDecimal alcohol, BigDecimal prijs, Brouwer brouwer, Soort soort) {
		this.naam = naam;
		this.alcohol = alcohol;
		this.prijs = prijs;
		this.brouwer = brouwer;
		this.soort = soort;
	}
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public BigDecimal getAlcohol() {
		return alcohol;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public Brouwer getBrouwer() {
		return brouwer;
	}
	public Soort getSoort() {
		return soort;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Bier other = (Bier) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equalsIgnoreCase(other.naam))
			return false;
		return true;
	}
	
	
	
}
