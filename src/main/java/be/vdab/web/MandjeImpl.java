package be.vdab.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class MandjeImpl implements Mandje, Serializable{
	private static final long serialVersionUID = 1L;
	private Map<Long, Integer> mandje = new HashMap<>();
	
	@Override
	public void addItem(long id, int aantal) {
		mandje.put(id, aantal);
	}

	@Override
	public Map<Long, Integer> getMandje() {
		return mandje;
	}

	@Override
	public void clear() {
		mandje.clear();
	}
	
}
