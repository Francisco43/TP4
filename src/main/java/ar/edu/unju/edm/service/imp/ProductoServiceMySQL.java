package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.IproductoDAO;
import ar.edu.unju.edm.service.ProductoService;

@Service
@Qualifier("implementacionMYSQLproducto")

public class ProductoServiceMySQL implements ProductoService{

	@Autowired
	Producto unProducto;
	@Autowired
	IproductoDAO iProductoDAO;
	@Override
	public void guardarProducto(Producto productoGuardado) {
		// TODO Auto-generated method stub
		iProductoDAO.save(productoGuardado);
	}

	@Override
	public Producto obtenerUnProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return (ArrayList<Producto>) iProductoDAO.findAll();
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto encontrarUnProducto(int cod) throws Exception {
		// TODO Auto-generated method stub
		return iProductoDAO.findByCodProducto(cod).orElseThrow(()->new Exception("El producto NO existe"));
	}

	@Override
	public Object crearProducto() {
		// TODO Auto-generated method stub
		return unProducto;
	}
 
	@Override
	public void modificarProducto(Producto productoModificado) throws Exception {
		// TODO Auto-generated method stub
		Producto productoAModificar = iProductoDAO.findByCodProducto(productoModificado.getCodProducto()).orElseThrow(()->new Exception("El Producto no fue encontrado"));
		cambiarProducto(productoModificado, productoAModificar);
		iProductoDAO.save(productoAModificar);
	}

	private void cambiarProducto(Producto productoModificado, Producto productoAModificar) {
		// TODO Auto-generated method stub
		productoAModificar.setCodProducto(productoModificado.getCodProducto());
		productoAModificar.setNombre(productoModificado.getNombre());
		productoAModificar.setMarca(productoModificado.getMarca());
		productoAModificar.setPrecio(productoModificado.getPrecio());
		productoAModificar.setStock(productoModificado.getStock());
    	productoAModificar.setDescripcion(productoModificado.getDescripcion());
	}
	@Override
	public void eliminarProducto(int id) throws Exception {
		// TODO Auto-generated method stub
		Producto productoEliminar = iProductoDAO.findByCodProducto(id).orElseThrow(()->new Exception("El Producto no fue encontrado"));
		iProductoDAO.delete(productoEliminar);
	}

	@Override
	public Producto obtenerProductoCodigo(int cod) throws Exception{
		// TODO Auto-generated method stub
		return iProductoDAO.findByCodProducto(cod).orElseThrow(()->new Exception("El Producto no fue encontrado"));
	}

}