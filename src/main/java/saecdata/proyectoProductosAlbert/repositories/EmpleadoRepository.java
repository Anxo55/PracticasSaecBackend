package saecdata.proyectoProductosAlbert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import saecdata.proyectoProductosAlbert.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    
}
