package co.com.donraul.app.services;

import co.com.donraul.app.models.Cliente;
import co.com.donraul.app.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    ClienteService clienteService;

    Cliente cliente = new Cliente("Juan","3113950933","1088987654");

    @Test
    void agregarCliente() {
        Mono<Cliente> clienteAgregado = clienteService.agregarCliente(cliente);
        StepVerifier.create(clienteAgregado).expectNext(cliente).verifyComplete();
    }

    @Test
    void buscarClientes() {
        Flux<Cliente> clienteBuscado = clienteService.buscarClientes();
        StepVerifier.create(clienteBuscado).expectNextMatches(response -> cliente.getClass().equals(response.getClass())).thenCancel().verify();
    }
}