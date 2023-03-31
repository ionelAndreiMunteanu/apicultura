package com.apicol.apicultura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameProduct;
    private String brand;
    private int quantites;
    private float price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private List<Product> listaProduse;

    @Override
    public String toString() {
        return "Product{" +            "id=" + id +
                ", name='" + nameProduct + '\'' +
                ", brand='" + brand + '\'' +  '}'+"\n";}



}


