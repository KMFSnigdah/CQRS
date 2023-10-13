package com.example.ProductService.command.api.aggregate;

import com.example.ProductService.command.api.commands.CreateProductCommand;
import com.example.ProductService.command.api.events.ProductCreatedEvent;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        ProductCreatedEvent productCreatedEvent
                = ProductCreatedEvent
                .builder()
                .productId(createProductCommand.getProductId())
                .name(createProductCommand.getName())
                .price(createProductCommand.getPrice())
                .quantity(createProductCommand.getQuantity())
                .build();

//        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
//        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        //Now publish a particular event
        AggregateLifecycle.apply(productCreatedEvent);
    }

    public ProductAggregate(){

    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.productId = productCreatedEvent.getProductId();
        this.quantity = productCreatedEvent.getQuantity();
        this.price = productCreatedEvent.getPrice();
        this.name = productCreatedEvent.getName();
    }


}
