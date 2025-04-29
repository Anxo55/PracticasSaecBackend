package saecdata.proyectoProductosAlbert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import saecdata.proyectoProductosAlbert.models.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {

}
