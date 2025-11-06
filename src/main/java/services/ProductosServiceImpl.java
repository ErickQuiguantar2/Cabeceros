package services;
/*
 * Clase ProductosServiceImpl
 *
 * Implementa la interfaz ProductoServicios y provee
 * un listado de productos de ejemplo.
 *
 * Autores: Erick Sanguña, Ian Morales, Jesus Viera
 * Fecha: 06/11/2025
 */
import models.Producto;
import java.util.Arrays;
import java.util.List;
/*
 * Clase que implementa los servicios de productos.
 * En esta implementación se retorna una lista fija de productos
 * como ejemplo, usando Arrays.asList.
 */
public class ProductosServiceImpl implements ProductoServicios {
    @Override
    // Retorna una lista inmutable de productos de ejemplo
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L, "Laptop", "Computación", 256.35),
                new Producto(2L, "Mouse", "Computación", 25.50),
                new Producto(3L, "Cocina", "Electrodoméstico", 85.50)
        );
    }
}
