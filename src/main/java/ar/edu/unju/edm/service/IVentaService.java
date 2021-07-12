package ar.edu.unju.edm.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Venta;

@Service
public interface IVentaService {

	public void guardarVenta(Venta unaVenta);
	public ArrayList<Venta> obtenerTodasVentas();
	public Venta encontrarUnaVenta(int cod) throws Exception;
	public Venta crearVenta();
	
}