package org.example.service_projet;

import org.example.service_projet.Configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
@EnableFeignClients
public class ServiceProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProjetApplication.class, args);
    }

}
