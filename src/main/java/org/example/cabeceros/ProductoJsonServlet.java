package org.example.cabeceros;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Producto;
import services.ProductoServicios;
import services.ProductosServiceImpl;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
 * Servlet que devuelve la lista de productos en formato JSON
 * URL: /productojson
 */
@WebServlet("/productojson")
public class ProductoJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductoServicios service = new ProductosServiceImpl();
        List<Producto> productos = service.listar();

        // Configura la respuesta como JSON
        resp.setContentType("application/json;charset=UTF-8");

        // Convierte la lista a JSON usando Gson
        Gson gson = new Gson();
        String json = gson.toJson(productos);

        try (PrintWriter out = resp.getWriter()) {
            out.print(json);
        }
    }
}
