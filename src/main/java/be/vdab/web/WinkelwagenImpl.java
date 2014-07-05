package be.vdab.web;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import be.vdab.entities.Bestelbon;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.INTERFACES)
public class WinkelwagenImpl implements Winkelwagen,Serializable {
	private static final long serialVersionUID=1L; 
	private Bestelbon bestelbon;

	
	@Override
	public Bestelbon getBestelbon() {
		return bestelbon;
	}
	@Override
	public void setBestelbon(Bestelbon bestelbon) {
		this.bestelbon = bestelbon;
	}
	

}
