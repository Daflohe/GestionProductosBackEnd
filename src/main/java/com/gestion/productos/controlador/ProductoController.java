package com.gestion.productos.controlador;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.productos.repositorio.ProductoRepositiorio;

import jakarta.persistence.EntityNotFoundException;

import com.gestion.productos.modelo.Producto;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="*")
public class ProductoController {
		@Autowired
		private ProductoRepositiorio repositorio;
	
		@GetMapping("/productos")
		public List<Producto> getAllProductos(){
			return repositorio.findAll();
		}
		
		
		@PostMapping("/productos")
		public Producto postProductos(@RequestBody Producto producto) {
			return repositorio.save(producto);
		}
		
		
		 @PostMapping("/productosM")
		    public void guardar(@RequestBody List<Producto> productos) {
		        for (Producto producto : productos) {
		            repositorio.save(producto);
		        }
		    }
		
		@GetMapping("/productos/{id}")
		public ResponseEntity<Producto> getByIdProductos(@PathVariable Long id){
			Producto producto = repositorio.findById(id)
					.orElseThrow();
			return ResponseEntity.ok(producto);
		}
		
		 @DeleteMapping("/productos/{id}")
		    public void delete(@PathVariable Long id) {
		        repositorio.deleteById(id);
		    }
		
		 @PutMapping("/productos/{id}")
		    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
		        Producto existente = repositorio.findById(id).orElseThrow();
		        if (existente == null) {
		            throw new EntityNotFoundException("La entidad no existe");
		        }
		        BeanUtils.copyProperties(producto, existente, "id");
		        repositorio.save(existente);
		        return ResponseEntity.ok(producto);
		    }
}
