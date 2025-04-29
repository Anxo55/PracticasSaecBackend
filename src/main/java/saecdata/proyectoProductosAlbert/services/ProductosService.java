package saecdata.proyectoProductosAlbert.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import saecdata.proyectoProductosAlbert.models.Productos;
import saecdata.proyectoProductosAlbert.repositories.ProductosRepository;

@Service
@Slf4j
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos> mostrarProductos() {
        log.info("Metodo que devuelve todos los productos");
        return productosRepository.findAll();
    }

    public Productos mostrarProductoPorId(Long id) {
        log.info("Metodo para mostrar un producto por su id");
        return productosRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Productos crearProducto(Productos productos) {
        log.info("Metodo para crear un producto");
        return productosRepository.save(productos);
    }

    public void borrarProducto(Long id) {
        log.info("Metodo para borrar un producto pro su id");
        productosRepository.deleteById(id);
    }

    public Productos actualizarProducto(Long id, Productos productoActualizado) {
        log.info("Metodo para actualizar un producto por su id");
        Optional<Productos> productoExistente = productosRepository.findById(id);

        if (productoExistente.isPresent()) {
            Productos producto = productoExistente.get();

            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());

            return productosRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado con el ID: " + id);
        }
    }

}
