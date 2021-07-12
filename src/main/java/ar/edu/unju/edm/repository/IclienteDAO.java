package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Cliente;

@Repository
public interface IclienteDAO extends CrudRepository<Cliente, Integer>{

	@Query("from Cliente c order by c.nroDocumento")
	public List<Cliente> obtenerClientes();
	
	public Optional<Cliente> findByNroDocumento(int dni);

	public Optional<Cliente> findByEmail(String email);
	
}