package br.edu.infnet.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.edu.infnet.webapi.client")
public class MainAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainAppApplication.class, args);
    }

}
