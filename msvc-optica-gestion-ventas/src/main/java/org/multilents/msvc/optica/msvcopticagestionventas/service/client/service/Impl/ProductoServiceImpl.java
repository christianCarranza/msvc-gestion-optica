package org.multilents.msvc.optica.msvcopticagestionventas.service.client.service.Impl;

import java.util.List;
import java.util.Objects;

import org.multilents.msvc.optica.msvcopticagestionventas.service.client.dto.ProductoDTO;
import org.multilents.msvc.optica.msvcopticagestionventas.service.client.service.ProductoService;
import org.multilents.msvc.optica.msvcopticagestionventas.utils.CustomResponse;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Component
public class ProductoServiceImpl implements ProductoService {

    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate;

    private String url="msvc-gestion-productos";

    //http://localhost:8080/v1/productos/findByIdActive/{{id}}

    public ProductoServiceImpl (RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.discoveryClient=discoveryClient;
        this.restTemplate = restTemplate;
        //log.info("this.getURI() "+this.getURI());
    }

    @Override
    public ProductoDTO findById(UUID id) {
        ResponseEntity<CustomResponse>  rEClienteDTO = restTemplate.getForEntity(this.getURI()+"/v1/clientes/"+id, CustomResponse.class);

        if (!Objects.isNull(rEClienteDTO)) {
            return (ProductoDTO) rEClienteDTO.getBody().getData();
        }
        return null;
    }

    private String getURI() {
        if (Objects.isNull(discoveryClient)) {
            log.info("discoveryClient is null");
            return "";
        }
        List<ServiceInstance> instances = discoveryClient.getInstances(url);

        if (Objects.isNull(instances) || instances.isEmpty()) return "not found";
        System.out.println(instances.get(0).getHost());
        String uri=instances.get(0).getUri().toString();
        log.info("uri" +uri);
        return uri;
    }

}
