package com.example.demo.controller.product;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/product")
    public String openProductPage(Model model) {
        if (model.getAttribute("productDto")==null)
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("productDtoList", productService.findAll());
        return "product/product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto productDto,
                                RedirectAttributes redirectAttributes) {
        if (productDto.getId() != null && !productDto.getId().equals("")){
        }
        productDto = productService.create(productDto);
        if (productDto != null) {
            redirectAttributes.addFlashAttribute("message", "create Sucessfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "not sucessfully");
        }
        return "redirect:/product/product";

    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteById(id);
        return "redirect:/product/product";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        ProductDto productDto = productService.findById(id);
        redirectAttributes.addFlashAttribute("productDto", productDto);
        return "redirect:/product/product";

    }
}
