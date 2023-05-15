package avenida.avenida.Services;

import avenida.avenida.Modelo.Producto;
import avenida.avenida.Repositorios.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return producto.get();
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(Long id, Producto productoDetails) {
        Producto producto = findById(id);
        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());
        return productoRepository.save(producto);
    }

    public void delete(Long id) {
        Producto producto = findById(id);
        productoRepository.delete(producto);
    }

    public Producto get(Long idProducto) {
        return null;
    }

    public Producto updateProducto(Long idProducto, Producto productoActualizado) {
        return null;
    }

    public void deleteProducto(Long idProducto) {
    }

    public Producto crearProducto(Producto producto) {
        return null;
    }
}

