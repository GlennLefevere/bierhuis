package be.vdab.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="soorten")
public class Soort {
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty
	private String naam;
	@OneToMany(mappedBy ="soort")
	private Set<Bier> bieren;
	public Soort() {
	}
	public Soort(String naam, Set<Bier> bieren) {
		this.naam = naam;
		this.bieren = bieren;
	}
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public Set<Bier> getBieren() {
		return bieren;
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
		Soort other = (Soort) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equalsIgnoreCase(other.naam))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return naam;
	}
	
	
	
}
