package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name="CLIENTES")
@Component
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCliente;
	@Column (name="documento")
	@Min(100000)
	@Max(99999999)
	private int nroDocumento;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	//Calendar
	//private Date fechaUltimCompra = new Date();
	@Column
	private String tipoDocumento;
	@Column
	private int codigoAreaTelefono;
	@Column
	private int numTelefono;
	@Column
	private String email;
	@Column
	@NotBlank (message="Campo obligatorio")
	private String nombreApellido;
	@Column
	private String password;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoAreaTelefono;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + nroDocumento;
		result = prime * result + numTelefono;
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codigoAreaTelefono != other.codigoAreaTelefono)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nroDocumento != other.nroDocumento)
			return false;
		if (numTelefono != other.numTelefono)
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nroDocumento=" + nroDocumento + ", fechaNacimiento=" + fechaNacimiento + ", tipoDocumento="
				+ tipoDocumento + ", codigoAreaTelefono=" + codigoAreaTelefono + ", numTelefono=" + numTelefono
				+ ", email=" + email + "]";
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		int edad = 0;
		LocalDate fechahoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechahoy);
		edad = periodo.getYears();		
		return edad;

	}
	
	public String getTiempoDesdeUltimaCompra() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaUltimaCompra, fechaActual);
		return " Tiempo desde la última compra: " + " Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays() ;
		
	}
	
	public String getTiempoProxCumple() {
		LocalDate hoy= LocalDate.now();
        LocalDate fechaCumpleaños= getFechaNacimiento();

        LocalDate proxCumpleaños = fechaCumpleaños.withYear(hoy.getYear());

        if (proxCumpleaños.isBefore(hoy) || proxCumpleaños.isEqual(hoy)) {
        	proxCumpleaños = proxCumpleaños.plusYears(1);
        }

        Period periodo = Period.between(hoy, proxCumpleaños);
        return "Tiempo hasta el proximo cumpleaños: " + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
	}
	
	
	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
 
	
}