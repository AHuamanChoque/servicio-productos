package idat.edu.pe.serviciopedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import idat.edu.pe.serviciopedido.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
