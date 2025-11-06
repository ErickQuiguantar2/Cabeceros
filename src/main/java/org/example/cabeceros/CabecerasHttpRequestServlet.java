package org.example.cabeceros;

/*
 * Clase Producto
 * Autores: Erick Sanguña,Ian Morales,Jesus Viera
 *
 * Fecha: 06/11/2025
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceros-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    /*
     * Maneja las peticiones GET mostrando información del request HTTP:
     * metodo, URI, URL, contexto, servlet, IP remota, puerto y cabeceras.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Se establece el tipo de contenido como HTML con codificación UTF-8
        resp.setContentType("text/html;charset=UTF-8");

        // Se obtienen datos de la petición HTTP
        String metodoHttp = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getRemoteAddr();
        int port = req.getServerPort();

        // Generación del contenido HTML
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Manejo de cabeceros 2025-2026</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Manejo de cabeceros</h1>");
            out.println("<ul>");
            out.println("<li>Método de petición: " + metodoHttp + "</li>");
            out.println("<li>URI: " + requestURI + "</li>");
            out.println("<li>URL: " + requestURL + "</li>");
            out.println("<li>Contexto: " + contextPath + "</li>");
            out.println("<li>Servlet: " + servletPath + "</li>");
            out.println("<li>IP Remota: " + ip + "</li>");
            out.println("<li>Puerto: " + port + "</li>");

            // Se listan todas las cabeceras HTTP de la petición

            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String header = headerNames.nextElement();
                out.println("<li>" + header + ": " + req.getHeader(header) + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
