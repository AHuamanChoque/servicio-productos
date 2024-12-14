package idat.edu.pe.serviciopedido.service;

import java.util.List;

import idat.edu.pe.serviciopedido.model.Pedido;

public interface IPedidoService {

    List<Pedido> getPedidos();
    Pedido obtenerPedidobyId(Integer idpedido);
    Pedido guardarPedido(Pedido pedido);
    void eliminarPedido(Integer idpedido);

}
