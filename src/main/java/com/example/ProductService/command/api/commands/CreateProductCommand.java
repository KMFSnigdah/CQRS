package com.example.ProductService.command.api.commands;

import com.example.ProductService.command.api.model.ProductRestModel;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private String aggregateId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

//    public static CreateProductCommand createWithGeneratedId(ProductRestModel productRestModel) {
//        String productId = UUID.randomUUID().toString();
//        return new CreateProductCommand(productId, productRestModel.getName(), productRestModel.getPrice(), productRestModel.getQuantity());
//    }
}
