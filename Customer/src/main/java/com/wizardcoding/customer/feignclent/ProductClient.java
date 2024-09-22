package com.wizardcoding.amqp.feignclent;

import com.wizardcoding.amqp.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product",url="http://localhost:8081")
public interface ProductClient {

    @GetMapping("api/v1/product/{id}")
    ResponseEntity<ProductResponse> getProductByCustomerId (@PathVariable("id") Long id);
}




