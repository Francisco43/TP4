package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

@Component 
public class Home {

	
		private String usuario;
		private String Contraseña;
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getContraseña() {
			return Contraseña;
		}
		public void setContraseña(String contraseña) {
			Contraseña = contraseña;
		} 
	
}