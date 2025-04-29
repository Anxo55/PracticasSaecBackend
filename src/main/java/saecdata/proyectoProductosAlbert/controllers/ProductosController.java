package saecdata.proyectoProductosAlbert.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import saecdata.proyectoProductosAlbert.models.Productos;
import saecdata.proyectoProductosAlbert.services.ProductosService;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Tag(name = "Producto", description = "Operaciones para crear, borrar y actualizar productos")
public class ProductosController {

    private final ProductosService productosService;

    @GetMapping
    @Operation(summary = "Listar productos", description = "Lista todos los productos creados")
    public List<Productos> mostrarProductos() {
        return productosService.mostrarProductos();
    }

    @PostMapping
    @Operation(summary = "Crear producto", description = "Creación de productos")
    public Productos crearProducto(@RequestBody Productos productos) {
        return productosService.crearProducto(productos);
    }

    @DeleteMapping
    @Operation(summary = "Eliminar producto", description = "Eliminar un producto por su ID")
    public void borrarProducto(Long id) {
        productosService.borrarProducto(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista un producto", description = "Lista un usuario específico")
    public Productos mostrarProductoPorId(@PathVariable Long id) {
        return productosService.mostrarProductoPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualización de los valores de un producto determinado")
    public Productos actualizarProducto(@PathVariable Long id, @RequestBody Productos productoActualizado) {
        return productosService.actualizarProducto(id, productoActualizado);
    }

    @GetMapping("/export/excel")
    @Operation(summary = "Exportar productos a Excel", description = "Genera un archivo Excel con todos los productos")
    public void exportarProductosExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=productos.xlsx");

        List<Productos> productos = productosService.mostrarProductos();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Productos");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Nombre");
        headerRow.createCell(2).setCellValue("Precio");
        headerRow.createCell(3).setCellValue("Stock");

        int rowNum = 1;
        for (Productos producto : productos) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(producto.getId());
            row.createCell(1).setCellValue(producto.getNombre());
            row.createCell(2).setCellValue(producto.getPrecio());
            row.createCell(3).setCellValue(producto.getStock());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }

}
