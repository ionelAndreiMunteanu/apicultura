package com.apicol.apicultura.service.implementation;

import com.apicol.apicultura.model.Product;
import com.apicol.apicultura.repository.BossRepository;
import com.apicol.apicultura.repository.ProductRepository;
import com.apicol.apicultura.repository.UserRepository;
import com.apicol.apicultura.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductImplementation( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void updateProduct(Product product, String nameProduct, String brand, int quantites, float price){
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setNameProduct(nameProduct);
        updateProduct.setBrand(brand);
        updateProduct.setQuantites(quantites);
        updateProduct.setPrice(price);
        productRepository.save(updateProduct);

    }
    @Override
    public void updateProduct(Product product, String nameProduct, String brand, int quantites){
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setNameProduct(nameProduct);
        updateProduct.setBrand(brand);
        updateProduct.setQuantites(quantites);
        productRepository.save(updateProduct);

    }
    @Override
    public void updateProduct(Product product, String nameProduct, String brand){
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setNameProduct(nameProduct);
        updateProduct.setBrand(brand);
        productRepository.save(updateProduct);

    }
    @Override
    public void updateProduct(Product product, String nameProduct){
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setNameProduct(nameProduct);
        productRepository.save(updateProduct);

    }
    @Override
    public void updateProduct(Product product, int quantites){
        Product updateProduct = productRepository.findById(product.getId()).get();
        updateProduct.setQuantites(quantites);
        productRepository.save(updateProduct);

    }
    @Override
    public List<Product> findProductbyUser() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findOneProductByUser(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
}
