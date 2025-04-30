package saecdata.proyectoProductosAlbert.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import saecdata.proyectoProductosAlbert.models.Empleado;
import saecdata.proyectoProductosAlbert.services.EmpleadoService;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadosController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/{id}")
    public Optional<Empleado> listarEmpleadoPorId(@PathVariable Long id) {
        return empleadoService.listarEmpleadoPorId(id);
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
    }

    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.actualizarEmpleado(id, empleado);
    }
    
}
