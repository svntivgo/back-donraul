package co.com.donraul.app.services;

import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.models.Vendedor;
import co.com.donraul.app.repositories.ProveedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VendedorServiceTest {

    @Autowired
    VendedorService vendedorService;

    Vendedor vendedor = new Vendedor("Felipe","3009853417","1090563214");

    @Test
    void agregarVendedor() {
        Mono<Vendedor> vendedorAgregado = vendedorService.agregarVendedor(vendedor);
        StepVerifier.create(vendedorAgregado).expectNext(vendedor).verifyComplete();
    }

    @Test
    void buscarVendedores() {
        Flux<Vendedor> vendedorBuscado = vendedorService.buscarVendedores();
        StepVerifier.create(vendedorBuscado).expectNextMatches(response -> vendedor.getClass().equals(response.getClass())).thenCancel().verify();
    }
}