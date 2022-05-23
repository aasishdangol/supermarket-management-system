package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto create(ProductDto productDto) {
        Product entity = Product.builder()
                .id(productDto.getId())
                .productName(productDto.getProductName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();
        entity = productRepo.save(entity);
        return ProductDto.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList=productRepo.findAll();
        return  productList.stream().map(entity -> ProductDto.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build()).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Integer id) {
        Optional<Product> optionalProduct=productRepo.findById(id);
        if (optionalProduct.isPresent()){
            Product entity =optionalProduct.get();
            return ProductDto.builder()
                    .id(entity.getId())
                    .productName(entity.getProductName())
                    .price(entity.getPrice())
                    .quantity(entity.getQuantity())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        productRepo.deleteById(id);

    }
}
