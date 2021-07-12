package ar.edu.unju.edm;

import java.io.IOException;
import java.util.Collection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		boolean userConsultor = false;
		boolean userRegistrador = false;
		boolean DNI = false;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("DNI")) {
				DNI = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("CONSULTOR")) {
					userConsultor = true;
					break;
				} else {
					userRegistrador = true;
					break;
				}
			}

	}
		if (DNI) {
			redirectStrategy.sendRedirect(request, response, "/cliente/mostrar");
		} else {
			if (userConsultor) {
				redirectStrategy.sendRedirect(request, response, "/consultor");
			} else {
				if (userRegistrador) {
					redirectStrategy.sendRedirect(request, response, "/registrador");
				} else {
					throw new IllegalStateException();
				}
			}
			}}

}