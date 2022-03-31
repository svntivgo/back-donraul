package co.com.donraul.app.controllers;

import co.com.donraul.app.models.Cliente;
import co.com.donraul.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    private Mono<Cliente> agregar(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }

    @PutMapping("/cliente/")
    private Mono<Cliente> actualizar(@RequestParam("id") String id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/cliente/")
    private Mono<Cliente> eliminar(@RequestParam("id") String id) {
        return clienteService.eliminarCliente(id);
    }

    @GetMapping("/clientes")
    private Flux<Cliente> buscarTodo() {
        return clienteService.buscarClientes();
    }

    @GetMapping("/cliente/")
    private Mono<Cliente> buscar(@RequestParam("numIdentificacion") String numIdentificacion) {
        return clienteService.buscarClientePorNumIdentificacion(numIdentificacion);
    }

    @GetMapping("/cliente/nombre/")
    private Flux<Cliente> buscarPorNombre(@RequestParam("nombre") String nombre) {
        return clienteService.buscarClientePorNombre(nombre);
    }
}
