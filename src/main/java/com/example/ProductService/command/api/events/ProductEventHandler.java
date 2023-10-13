package com.example.ProductService.command.api.events;

import com.example.ProductService.command.api.data.Product;
import com.example.ProductService.command.api.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) throws Exception {
      Product product =
              Product
                      .builder()
                      .productId(event.getProductId())
                      .name(event.getName())
                      .price(event.getPrice())
                      .quantity(event.getQuantity())
                      .build();

      // Save in Database
      productRepository.save(product);

      // Intentional create exception
        throw new Exception("Exception occurred");
    }
}
