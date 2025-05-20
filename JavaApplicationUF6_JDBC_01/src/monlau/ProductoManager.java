
package monlau;

import monlau.dao.ProductoDAO;
import monlau.dao.ProductoDAOImpl;
import monlau.model.Producto;

public class ProductoManager {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAOImpl();

        // Crear un nuevo producto
        Producto producto = new Producto(300, "Chilaquiles verdes", 35.0);
        productoDAO.insert(producto);
        System.out.println("✅ Producto insertado");

        // Leer el producto
        Producto p = productoDAO.read(300);
        System.out.println("📦 Producto leído: " + p);

        // Actualizar el producto
        p.setNombre("Chilaquiles rojos");
        p.setPrecio(40.0);
        productoDAO.update(p);
        System.out.println("🔄 Producto actualizado");

        // Leer el producto actualizado
        Producto actualizado = productoDAO.read(300);
        System.out.println("📦 Producto actualizado leído: " + actualizado);

        // Borrar el producto
        productoDAO.delete(actualizado);
        System.out.println("❌ Producto eliminado");

        // Intentar leerlo de nuevo (debería ser null)
        Producto eliminado = productoDAO.read(300);
        if (eliminado == null) {
            System.out.println("🚫 Producto ya no existe en la base de datos");
        } else {
            System.out.println("🧐 Aún existe: " + eliminado);
        }
    }
}
