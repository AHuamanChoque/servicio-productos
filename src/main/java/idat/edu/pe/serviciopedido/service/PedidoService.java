package idat.edu.pe.serviciopedido.service;

import java.util.List;
import org.springframework.stereotype.Service;
import idat.edu.pe.serviciopedido.model.Pedido;
import idat.edu.pe.serviciopedido.repository.PedidoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoService implements IPedidoService{
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPedidobyId(Integer idpedido){
        return pedidoRepository.findById(idpedido).orElse(null);
    }

    @Override
    public Pedido guardarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    @Override
    public void eliminarPedido(Integer idpedido){
        pedidoRepository.deleteById(idpedido);
    }

}
