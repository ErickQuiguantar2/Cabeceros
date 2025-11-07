package models;

/*
 * Clase Producto
 * Representa un producto con sus atributos básicos: id, nombre, tipo y precio.
 * Autores: Erick Sanguña,Ian Morales,Jesus Viera
 *
 * Fecha: 06/11/2025
 */

public class Producto {
    private Long idProducto;
    private String nombre;
    private String tipo;
    private double precio;

    public Producto() {}

    /*
     * Constructor con parámetros
     * Permite crear un objeto Producto inicializando todos sus atributos.
     *
     * @param idProducto Identificador del producto
     * @param nombre Nombre del producto
     * @param tipo Tipo o categoría del producto
     * @param precio Precio del producto
     */
    public Producto(Long idProducto, String nombre, String tipo, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Métodos getters y setters

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getId() {
        return idProducto;
    }

}
