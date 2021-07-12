package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.repository.IclienteDAO;

@Service
public class LogginClienteServiceImp implements UserDetailsService {

	@Autowired
	IclienteDAO iClienteDAO;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		
		System.out.println("bbbbbbbbbbbbbbbbbb");
		Cliente clienteEncontrado = iClienteDAO.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Cliente inválido"));

		
		List<GrantedAuthority> tipos = new ArrayList<>();
		
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(clienteEncontrado.getTipoDocumento());
		tipos.add(grantedAuthority);
		System.out.println("cccccccccccccccccccccc");
		
		UserDetails user = (UserDetails) new User(email, clienteEncontrado.getPassword(), tipos);
		return user;
	}
	
}