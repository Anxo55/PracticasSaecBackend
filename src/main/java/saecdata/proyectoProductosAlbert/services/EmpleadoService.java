package saecdata.proyectoProductosAlbert.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import saecdata.proyectoProductosAlbert.models.Empleado;
import saecdata.proyectoProductosAlbert.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado crearEmpleado(Empleado empleado) {
        empleado.setContrasena(passwordEncoder.encode(empleado.getContrasena()));
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> listarEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado actualizarEmpleado(Long id, Empleado empleadoActualizado) {
        if (empleadoRepository.existsById(id)) {
            empleadoActualizado.setId(id);
            return empleadoRepository.save(empleadoActualizado);
        }
        return null;
    }

    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
    
}
