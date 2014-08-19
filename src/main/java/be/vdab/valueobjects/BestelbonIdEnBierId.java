package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BestelbonIdEnBierId implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="bestelbonid")
	private long bestelbonId;
	@Column(name="bierid")
	private long bierId;
	
	public long getBestelbonId() {
		return bestelbonId;
	}
	public void setBestelbonId(long bestelbonId) {
		this.bestelbonId = bestelbonId;
	}
	public long getBierId() {
		return bierId;
	}
	public void setBierId(long bierId) {
		this.bierId = bierId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bestelbonId ^ (bestelbonId >>> 32));
		result = prime * result + (int) (bierId ^ (bierId >>> 32));
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
		BestelbonIdEnBierId other = (BestelbonIdEnBierId) obj;
		if (bestelbonId != other.bestelbonId)
			return false;
		if (bierId != other.bierId)
			return false;
		return true;
	}
	
}
