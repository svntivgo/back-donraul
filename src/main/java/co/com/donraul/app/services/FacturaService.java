package co.com.donraul.app.services;

import co.com.donraul.app.models.Cliente;
import co.com.donraul.app.models.Factura;
import co.com.donraul.app.models.Producto;
import co.com.donraul.app.models.Vendedor;
import co.com.donraul.app.repositories.ClienteRepository;
import co.com.donraul.app.repositories.FacturaRepository;
import co.com.donraul.app.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    VendedorRepository vendedorRepository;
    @Autowired
    ProductoService productoService;

    public Mono<Factura> agregarFactura (String cedulaCliente, String cedulaVendedor, List<Producto> productos) {
        Cliente cliente = clienteRepository.findByNumIdentificacion(cedulaCliente).block();
        Vendedor vendedor = vendedorRepository.findByNumIdentificacion(cedulaVendedor).block();
        List<Producto> sinModificar = productos;
        Factura factura = new Factura(LocalDate.now(),cliente,vendedor,productos);

        for (int i = 0; i < sinModificar.size(); i++) {
            Integer cantidadNegativa = -sinModificar.get(i).getCantidad();
            sinModificar.get(i).setCantidad(cantidadNegativa);
            productoService.actualizarProducto(sinModificar.get(i).getId(), sinModificar.get(i)).subscribe();
        }

        return facturaRepository.save(factura);
    }

    public Mono<Factura> buscarFacturaPorId(String id) {
        return facturaRepository.findById(id);
    }

    public Flux<Factura> buscarFacturas() {
        return facturaRepository.findAll();
    }
}
