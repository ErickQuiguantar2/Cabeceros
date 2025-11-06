package services;

import models.Producto;
import java.util.Arrays;
import java.util.List;

public class ProductosServiceImpl implements ProductoServicios {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L, "Laptop", "Computación", 256.35),
                new Producto(2L, "Mouse", "Computación", 25.50),
                new Producto(3L, "Cocina", "Electrodoméstico", 85.50)
        );
    }
}
