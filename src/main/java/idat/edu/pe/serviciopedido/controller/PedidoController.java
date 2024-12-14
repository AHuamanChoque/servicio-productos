package idat.edu.pe.serviciopedido.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import idat.edu.pe.serviciopedido.Messaging.PedidoProducer;
import idat.edu.pe.serviciopedido.model.Pedido;
import idat.edu.pe.serviciopedido.service.IPedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@AllArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final IPedidoService iPedidoService;
    private final PedidoProducer pedidoProducer; 
    @GetMapping("/")
    @ResponseBody
    public List<Pedido> getPedidos() {
        return iPedidoService.getPedidos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Pedido obtenerPedidobyId(@PathVariable("id") Integer idpedido) {
        return iPedidoService.obtenerPedidobyId(idpedido);
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = iPedidoService.guardarPedido(pedido);

        String mensaje = "Pedido creado: " + nuevoPedido.toString();
        pedidoProducer.enviarMensaje(mensaje);

        return ResponseEntity.ok(nuevoPedido);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Pedido> actualizarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoActualizado = iPedidoService.guardarPedido(pedido);

        String mensaje = "Pedido actualizado: " + pedidoActualizado.toString();
        pedidoProducer.enviarMensaje(mensaje);

        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> eliminarPedido(@PathVariable("id") Integer idpedido) {
        iPedidoService.eliminarPedido(idpedido);

        String mensaje = "Pedido eliminado con ID: " + idpedido;
        pedidoProducer.enviarMensaje(mensaje);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

    

    



