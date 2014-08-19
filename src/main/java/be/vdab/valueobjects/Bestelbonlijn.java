package be.vdab.valueobjects;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.vdab.entities.Bier;


@Embeddable
public class Bestelbonlijn {
	@ManyToOne
	@JoinColumn(name="bierid")
	private Bier bier;
	private int aantal;
	
	public Bestelbonlijn() {
	}
	
	public Bestelbonlijn(Bier bier, int aantal) {
		this.bier = bier;
		this.aantal = aantal;
	}

	public Bier getBier() {
		return bier;
	}

	public void setBier(Bier bier) {
		this.bier = bier;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public BigDecimal getTeBetalen(){
		return bier.getPrijs().multiply(new BigDecimal(aantal));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aantal;
		result = prime * result + ((bier == null) ? 0 : (int) bier.getId());
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
		Bestelbonlijn other = (Bestelbonlijn) obj;
		if (aantal != other.aantal)
			return false;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}
	
}
