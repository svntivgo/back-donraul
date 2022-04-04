package co.com.donraul.app.services;

import co.com.donraul.app.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FacturaServiceTest {

    @Autowired
    FacturaService facturaService;

    List<Producto> productos = new ArrayList<>();

    Producto producto = new Producto("1","producto",10,2,1,10,"NORMAL");

    Vendedor vendedor = new Vendedor("Felipe","3009853417","1090563214");

    Cliente cliente = new Cliente("Juan","3113950933","1088987654");

    Factura factura = new Factura(LocalDate.now(),cliente,vendedor,productos);

    @Test
    void agregarFactura() {
        productos.add(producto);

        Mono<Factura> facturaAgregado = facturaService.agregarFactura(cliente.getId(),vendedor.getId(),productos);
        StepVerifier.create(facturaAgregado).expectNextMatches(response -> factura.getClass().equals(response.getClass())).thenCancel().verify();
    }

    @Test
    void buscarFacturas() {
        Flux<Factura> facturaBuscada = facturaService.buscarFacturas();
        StepVerifier.create(facturaBuscada).expectNextMatches(response -> factura.getClass().equals(response.getClass())).thenCancel().verify();
    }
}