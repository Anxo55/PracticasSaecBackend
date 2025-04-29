package saecdata.proyectoProductosAlbert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saecdata.proyectoProductosAlbert.models.Categorias;
import saecdata.proyectoProductosAlbert.repositories.CategoriasRepository;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Categorias> listarCategorias() {
        return categoriasRepository.findAll();
    }

    public Categorias crearCategoria(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

}
