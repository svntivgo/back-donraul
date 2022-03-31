package co.com.donraul.app.services;

import co.com.donraul.app.models.Producto;
import co.com.donraul.app.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public Mono<Producto> agregarProducto (Producto producto) {
        return productoRepository.save(producto);
    }

    public Mono<Producto> actualizarProducto (String id, Producto producto) {
        return productoRepository.findById(id).flatMap(product -> {
            producto.setId(id);
            producto.setEstado();
            return agregarProducto(producto);
        });
    }

    public Mono<Producto> eliminarProducto (String id) {
        return productoRepository.findById(id).flatMap(producto ->
                productoRepository.deleteById(producto.getId()).thenReturn(producto)
        );
    }

    public Mono<Producto> buscarProductosPorId (String id) {
        return productoRepository.findById(id);
    }

    public Flux<Producto> buscarProductos () {
        return productoRepository.findAll();
    }

    public Flux<Producto> buscarProductosPorNombre (String name) {
        return productoRepository.findByName(name);
    }

    public Flux<Producto> buscarProductoPorEstado (String estado) {
        return productoRepository.findByEstado(estado);
    }
}
