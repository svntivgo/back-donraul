package co.com.donraul.app.services;

import co.com.donraul.app.models.Cliente;
import co.com.donraul.app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Mono<Cliente> agregarCliente (Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Mono<Cliente> actualizarCliente (String id, Cliente cliente) {
        return clienteRepository.findById(id).flatMap(client -> {
            cliente.setId(id);
            return agregarCliente(cliente);
        });
    }

    public Mono<Cliente> eliminarCliente (String id) {
        return clienteRepository.findById(id).flatMap(cliente ->
                clienteRepository.deleteById(cliente.getId()).thenReturn(cliente)
                );
    }

    public Flux<Cliente> buscarClientes () {
        return clienteRepository.findAll();
    }

    public Mono<Cliente> buscarClientePorNumIdentificacion (String numIdentificacion) {
        return clienteRepository.findByNumIdentificacion(numIdentificacion);
    }

    public Flux<Cliente> buscarClientePorNombre (String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
}
