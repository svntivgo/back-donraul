package co.com.donraul.app.controllers;

import co.com.donraul.app.models.Factura;
import co.com.donraul.app.models.Producto;
import co.com.donraul.app.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @PostMapping("/factura/")
    public Mono<Factura> agregar(@RequestParam String cedulaCliente, @RequestParam String cedulaVendedor, @RequestBody List<Producto> productos) {
        return facturaService.agregarFactura(cedulaCliente,cedulaVendedor,productos);
    }

    @GetMapping("/factura/")
    public Mono<Factura> buscarPorId(@RequestParam String id) {
        return facturaService.buscarFacturaPorId(id);
    }

    @GetMapping("/facturas")
    public Flux<Factura> buscarTodo() {
        return facturaService.buscarFacturas();
    }
}
