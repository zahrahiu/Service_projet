package org.example.service_projet.Client;

import org.example.service_projet.Configuration.FeignConfig;
import org.example.service_projet.DTO.ChercheurResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-chercheur", url = "http://localhost:8082/v1/chercheurs",
        configuration = FeignConfig.class
)
public interface ChercheurClient {
    @GetMapping("/{id}")
    ChercheurResponseDTO getChercheurById(@PathVariable("id") Long id);
}
