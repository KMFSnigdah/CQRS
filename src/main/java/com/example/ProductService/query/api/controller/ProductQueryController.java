//package com.example.ProductService.query.api.controller;
//
//import com.example.ProductService.command.api.model.ProductRestModel;
//import com.example.ProductService.query.api.quries.GetProductByIdQuery;
//import com.example.ProductService.query.api.quries.GetProductsQuery;
//import org.axonframework.messaging.responsetypes.ResponseTypes;
//import org.axonframework.queryhandling.QueryGateway;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//public class ProductQueryController {
//
//    private QueryGateway queryGateway;
//
//    public ProductQueryController(QueryGateway queryGateway) {
//        this.queryGateway = queryGateway;
//    }
//
//    @GetMapping("/all")
//    public List<ProductRestModel> getAllProducts(){
//        GetProductsQuery getProductsQuery = new GetProductsQuery();
//
//        return queryGateway.query(getProductsQuery,
//                ResponseTypes.multipleInstancesOf(ProductRestModel.class))
//                .join();
//    }
//
//
//    @GetMapping("/byId/{productId}")
//    public ProductRestModel getProductById(@PathVariable String productId) {
//        // Create a query to get the product by ID
//        GetProductByIdQuery getProductByIdQuery = new GetProductByIdQuery(productId);
//
//        // Use the queryGateway to fetch the product
//        return queryGateway.query(getProductByIdQuery, ProductRestModel.class).join();
//    }
//
//
//}
