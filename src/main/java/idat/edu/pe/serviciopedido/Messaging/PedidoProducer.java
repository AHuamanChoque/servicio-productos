package idat.edu.pe.serviciopedido.Messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void enviarMensaje(String mensaje){
        jmsTemplate.convertAndSend("pedido.cambios.queue", mensaje);
    }
}
