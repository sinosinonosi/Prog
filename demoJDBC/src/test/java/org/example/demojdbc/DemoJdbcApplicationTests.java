package org.example.demojdbc;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql({"/schema.sql"})
class DemoJdbcApplicationTests {

    @Autowired
    ProductoRepository repositorio;

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        Producto producto = new Producto("Parrilla", 32.12);
        repositorio.insertar(producto);
        producto = new Producto("Locomotora", 456);
        repositorio.insertar(producto);
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

  @Test
    void borrarProducto() {
        Producto producto = new Producto("Parrilla");
        repositorio.borrar(producto);
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(1, lista.size());

    }

    @Test
    void buscarUno() {
        Producto producto = repositorio.buscarUno("Locomotora");
        assertEquals("Locomotora", producto.getNombre());
    }


}
