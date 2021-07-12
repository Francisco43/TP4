package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.service.IClienteService;
import ar.edu.unju.edm.util.ListadoClientes;

@Service
public class ClienteServiceImp implements IClienteService {
	
	private List<Cliente> listadoClientes = ListadoClientes.clientes;
	
	@Autowired
	Cliente unCliente;

	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		listadoClientes.add(unCliente);		
	}
	
	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}
 
	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return listadoClientes;
	}

	@Override
	public Cliente encontrarUnCliente(int dni) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listadoClientes.size(); i++){
		    if (listadoClientes.get(i).getNroDocumento() == dni) {
		    	unCliente = listadoClientes.get(i);
		    }
		}
		return unCliente;
	}

	@Override
	public void modificarCliente(Cliente clienteModificado) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listadoClientes.size(); i++){
		    if (listadoClientes.get(i).getNroDocumento() == clienteModificado.getNroDocumento()) {
		    	listadoClientes.set(i, clienteModificado);
		    }
		}
	}

	@Override
	public void eliminarCliente(int id) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < listadoClientes.size(); i++){
		    if (listadoClientes.get(i).getNroDocumento() == id) {
		    	listadoClientes.remove(i);
		    }
		}
	}

}