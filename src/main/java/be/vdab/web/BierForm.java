package be.vdab.web;

import javax.validation.constraints.Min;

public class BierForm {
	@Min(1)
	private int aantal;

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

}
