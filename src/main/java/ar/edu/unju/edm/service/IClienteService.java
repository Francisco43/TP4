package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
@Service 
public interface IClienteService {
	public void guardarCliente(Cliente unCliente);
	public Cliente crearCliente();
	public List<Cliente> obtenerTodosClientes();
	public Cliente encontrarUnCliente(int dni) throws Exception;

	public void modificarCliente(Cliente unCliente) throws Exception;
	public void eliminarCliente(int dni) throws Exception;
}