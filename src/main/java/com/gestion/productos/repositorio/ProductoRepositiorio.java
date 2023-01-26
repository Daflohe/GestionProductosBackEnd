package com.gestion.productos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.productos.modelo.Producto;

@Repository
public interface ProductoRepositiorio extends JpaRepository<Producto, Long>{

}
