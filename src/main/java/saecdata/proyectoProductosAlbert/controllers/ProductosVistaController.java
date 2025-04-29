package saecdata.proyectoProductosAlbert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import saecdata.proyectoProductosAlbert.models.Productos;
import saecdata.proyectoProductosAlbert.services.ProductosService;

@Controller
@RequiredArgsConstructor
public class ProductosVistaController {

    private final ProductosService productosService;

    @GetMapping("/vista/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productosService.mostrarProductos());
        return "productos/lista";
    }

    @GetMapping("/vista/productos/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        Productos producto = productosService.mostrarProductoPorId(id);
        model.addAttribute("producto", producto);
        return "productos/ver";
    }

    @GetMapping("/vista/productos/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Productos());
        return "productos/formulario";
    }

    @PostMapping("/vista/productos/guardar")
    public String guardarNuevoProducto(Productos producto) {
        productosService.crearProducto(producto);
        return "redirect:/vista/productos";
    }

    @GetMapping("/vista/productos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Productos producto = productosService.mostrarProductoPorId(id);
        model.addAttribute("producto", producto);
        return "productos/formulario";
    }

    @GetMapping("/vista/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productosService.borrarProducto(id);
        return "redirect:/vista/productos";
    }

}
