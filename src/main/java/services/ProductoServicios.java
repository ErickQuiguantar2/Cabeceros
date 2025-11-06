package services;

/*
 * plantilla que va a implemnetar atributos a otras clases en forma de listas
 * que contiene los productos
 * */

import models.Producto;

import java.util.List;

public interface ProductoServicios {

    List<Producto> listar();
}
