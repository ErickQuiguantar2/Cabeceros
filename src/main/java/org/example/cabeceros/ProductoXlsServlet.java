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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoServicios service = new ProductosServiceImpl();
        List<Producto> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");
        String servletPath=req.getServletPath();
        boolean esXls=servletPath.endsWith(".xls");
        if (esXls){
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        }
        try (PrintWriter out = resp.getWriter()) {
            if (!esXls) {
                //Creo la plantilla html
                out.print("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"utf-8\">");
                out.println("<title>Listado dre Productos</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Listado de productos</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/producto.xls" + "\">exportar a excel</a></p>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productojson" + "\">mostrar json</a></p>");
            }

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            out.println("<th>precio</th>");
            out.println("</tr>");
            productos.forEach(p->{
                out.println("<tr>");
                out.println("<td>"+p.getId()+"</td>");
                out.println("<td>"+p.getNombre()+"</td>");
                out.println("<td>"+p.getTipo()+"</td>");
                out.println("<td>"+p.getPrecio()+"</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            if (!esXls) {
                out.println("</body>");
                out.println("</html>");
            }

        }
    }
}
