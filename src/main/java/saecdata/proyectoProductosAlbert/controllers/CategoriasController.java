package saecdata.proyectoProductosAlbert.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import saecdata.proyectoProductosAlbert.models.Categorias;
import saecdata.proyectoProductosAlbert.services.CategoriasService;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public List<Categorias> listarCategorias() {
        return categoriasService.listarCategorias();
    }

    @PostMapping
    public Categorias crearCategoria(@RequestBody Categorias categorias) {
        return categoriasService.crearCategoria(categorias);
    }

}
