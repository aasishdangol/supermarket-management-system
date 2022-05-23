package com.example.demo.service;

import com.example.demo.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto create(ProductDto productDto);

    List<ProductDto> findAll();

    ProductDto findById(Integer id);

    void deleteById(Integer id);

}
