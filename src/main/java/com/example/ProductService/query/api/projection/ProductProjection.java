//package com.example.ProductService.query.api.projection;
//
//import com.example.ProductService.command.api.data.Product;
//import com.example.ProductService.command.api.data.ProductRepository;
//import com.example.ProductService.command.api.model.ProductRestModel;
//import com.example.ProductService.query.api.quries.GetProductByIdQuery;
//import com.example.ProductService.query.api.quries.GetProductsQuery;
//import org.axonframework.queryhandling.QueryHandler;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class ProductProjection {
//    private ProductRepository productRepository;
//
//    public ProductProjection(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @QueryHandler
//    public List<ProductRestModel> handle(GetProductsQuery productsQuery){
//        List<Product> products = productRepository.findAll();
//
//        List<ProductRestModel> productRestModel =
//                products.stream().map(
//                        product -> ProductRestModel
//                                .builder()
//                                .name(product.getName())
//                                .price(product.getPrice())
//                                .quantity(product.getQuantity())
//                                .build()).collect(Collectors.toList());
//
//        return  productRestModel;
//    }
//
//    @QueryHandler
//    public ProductRestModel handle(GetProductByIdQuery productQuery) {
//        // Fetch the product by its ID from the repository
//        Product product = productRepository.findById(productQuery.getProductId()).orElse(null);
//
////        if (product == null) {
////            // Handle not found or return an appropriate response
////            // You can throw an exception or return a suitable response for a not found product
////            // Example: throw new ProductNotFoundException("Product not found");
////        }
//
//        // Map the product to ProductRestModel and return it
//        return ProductRestModel
//                .builder()
//                .name(product.getName())
//                .price(product.getPrice())
//                .quantity(product.getQuantity())
//                .build();
//    }
//
//}
