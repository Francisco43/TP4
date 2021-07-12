package ar.edu.unju.edm.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public interface ProductoService {
	

	public void guardarProducto(Producto unProducto);
	public Producto obtenerUnProducto(String nombreProducto);
	public ArrayList<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
	public Producto obtenerUltimoProducto();
	public Producto encontrarUnProducto(int cod) throws Exception;
	public Object crearProducto();
	public void modificarProducto(Producto productoModificado) throws Exception;
	public void eliminarProducto(int id) throws Exception;
	public Producto obtenerProductoCodigo(int cod) throws Exception;
}