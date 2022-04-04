package co.com.donraul.app.services;

import co.com.donraul.app.models.Cliente;
import co.com.donraul.app.models.Proveedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProveedorServiceTest {

    @Autowired
    ProveedorService proveedorService;

    Proveedor proveedor = new Proveedor("Camilo","3105263147","3456852");

    @Test
    void agregarProveedor() {
        Mono<Proveedor> clienteAgregado = proveedorService.agregarProveedor(proveedor);
        StepVerifier.create(clienteAgregado).expectNext(proveedor).verifyComplete();
    }

    @Test
    void buscarClientes() {
        Flux<Proveedor> proveedorBuscado = proveedorService.buscarProveedores();
        StepVerifier.create(proveedorBuscado).expectNextMatches(response -> proveedor.getClass().equals(response.getClass())).thenCancel().verify();
    }
}