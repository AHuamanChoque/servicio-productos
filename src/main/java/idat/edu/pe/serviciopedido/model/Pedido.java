// Pedido.java
package idat.edu.pe.serviciopedido.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpedido;

    @Column(name = "estadopedido", columnDefinition = "VARCHAR(255)")
    private String estadopedido;

    @Column(name = "tipopedido", columnDefinition = "VARCHAR(255)")
    private String tipopedido;

    @Column(name = "fechapedido", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechapedido;


    @Column(name = "idreserva", columnDefinition = "idreserva")
    private Integer idreserva; 
}
