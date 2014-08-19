package be.vdab.web;

import java.util.Map;

public interface Mandje {
	void addItem(long id, int aantal);
	Map<Long, Integer> getMandje();
}
