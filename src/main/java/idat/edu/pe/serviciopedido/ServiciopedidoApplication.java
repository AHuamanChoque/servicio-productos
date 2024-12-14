package idat.edu.pe.serviciopedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"idat.edu.pe.serviciopedido"})
public class ServiciopedidoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiciopedidoApplication.class, args);
    }
}