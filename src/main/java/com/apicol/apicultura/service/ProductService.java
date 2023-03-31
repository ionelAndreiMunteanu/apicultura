package com.apicol.apicultura.service;

import com.apicol.apicultura.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductService {
    //product
    void updateProduct(Product product, String nameProduct, String brand, int quantites, float price);
    void updateProduct(Product product, String nameProduct, String brand, int quantites);
    void updateProduct(Product product, String nameProduct, String brand);
    void updateProduct(Product product, String nameProduct);
    void updateProduct(Product product, int quantites);
    void deleteProduct(Product product);
    List<Product> findProductbyUser();
    Optional<Product> findOneProductByUser(Long id);
}
