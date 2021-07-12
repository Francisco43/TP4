package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	@Qualifier("implementacionMYSQLproducto")
	ProductoService productoService;
	
	@GetMapping("/producto/mostrar")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", productoService.obtenerProductoNuevo());
		model.addAttribute("productos", productoService.obtenerTodosProductos());
		return("producto");
	}
	
	@GetMapping("/producto/editar/{codProducto}")
	public String editarProducto(Model model, @PathVariable(name="codProducto") int cod) throws Exception {
		try {
			Producto productoEncontrado = productoService.encontrarUnProducto(cod);
			model.addAttribute("unProducto", productoEncontrado);
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unProducto", productoService.crearProducto());
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("productos", productoService.obtenerTodosProductos());
		return("producto");
	}

	
	@PostMapping("/producto/guardar")
	public String guardarNuevoProducto(@ModelAttribute("unProducto") Producto nuevoProducto, Model model) {
		productoService.guardarProducto(nuevoProducto);
		System.out.println(productoService.obtenerTodosProductos().get(0).getMarca()); //linea de control para saber si se mando bien el producto 
		
		
		return "redirect:/producto/mostrar";
		
	}
	
	@PostMapping("/producto/modificar")
	public String modificarProducto(@ModelAttribute("unProducto") Producto productoModificado, Model model) {
		try {
			productoService.modificarProducto(productoModificado);
			model.addAttribute("unProducto", new Producto());				
			model.addAttribute("editMode", "false");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unProducto", productoModificado);			
			model.addAttribute("productos", productoService.obtenerTodosProductos());
			model.addAttribute("editMode", "true");
		}
		model.addAttribute("productos", productoService.obtenerTodosProductos());
		return("producto");
	}
	
	@GetMapping("/producto/eliminarProducto/{id}")
	public String eliminarProducto(Model model, @PathVariable(name="id") int id) {
		try {			productoService.eliminarProducto(id);			
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/producto/mostrar";
	}
	
	@GetMapping("/volver")
	public String cargarNuevoProducto(Model model) {
		
		return("redirect:/producto");
	}
}