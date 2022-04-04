package co.com.donraul.app.services;

import co.com.donraul.app.models.Producto;
import co.com.donraul.app.models.Vendedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductoServiceTest {

    @Autowired
    ProductoService productoService;

    Producto producto = new Producto("1","producto",10,2,1,10,"NORMAL");

    @Test
    void agregarProducto() {
        Mono<Producto> productoAgregado = productoService.agregarProducto(producto);
        StepVerifier.create(productoAgregado).expectNext(producto).verifyComplete();
    }

    @Test
    void buscarProductos() {
        Flux<Producto> productoBuscado = productoService.buscarProductos();
        StepVerifier.create(productoBuscado).expectNextMatches(response -> producto.getClass().equals(response.getClass())).thenCancel().verify();
    }
}