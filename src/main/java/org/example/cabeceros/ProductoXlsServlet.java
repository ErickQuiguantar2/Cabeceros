package org.example.cabeceros;
/*
 * Clase ProductoXlsServlet
 *
 * Servlet que genera un listado de productos en formato HTML (simulando un XLS).
 * Obtiene los productos desde el servicio ProductoServicios y los muestra en una tabla.
 *
 * Autores: Erick Sanguña, Ian Morales, Jesus Viera
 * Fecha: 06/11/2025
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Producto;
import services.ProductoServicios;
import services.ProductosServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
 * Servlet que atiende las rutas "/producto.xls" y "/producto"
 * Genera un listado de productos en una tabla HTML.
 */

@WebServlet({"/producto.xls","/producto"})
public class ProductoXlsServlet extends HttpServlet {

    /*
     * Maneja las peticiones GET mostrando la lista de productos
     * en una tabla HTML.
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductoServicios servicio = new ProductosServiceImpl();
        List<Producto> productos = servicio.listar();

        // Configurar el tipo de contenido para Excel
        resp.setContentType("application/vnd.ms-excel");
        // Forzar descarga con un nombre de archivo
        resp.setHeader("Content-Disposition", "attachment; filename=productos.xls");

        try (PrintWriter out = resp.getWriter()) {
            // Generar contenido tipo tabla HTML que Excel puede abrir
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>ID Producto</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Tipo</th>");
            out.println("<th>Precio</th>");
            out.println("</tr>");
            for (Producto p : productos) {
                out.println("<tr>");
                out.println("<td>" + p.getIdProducto() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                out.println("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }
}
