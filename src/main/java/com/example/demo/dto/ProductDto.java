package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDto {
    private Integer id;
    private String productName;
    private Integer price;
    private Integer quantity;
}
