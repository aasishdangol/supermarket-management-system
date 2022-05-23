package com.example.demo.controller.category;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController{

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorypage")
    public String openCategoryPage(Model model) {
        if (model.getAttribute("categoryDto")==null)
       model.addAttribute("categoryDto",new CategoryDto());

       model.addAttribute("categoryDtoList",categoryService.findAll());

        return "category/categorypage";
    }


    @PostMapping("/create")
    public String createCategory(@ModelAttribute CategoryDto categoryDto,
                                 RedirectAttributes redirectAttributes){
        categoryDto=categoryService.create(categoryDto);
        if (categoryDto != null) {
            redirectAttributes.addFlashAttribute("message", "create Sucessfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "not sucessfully");
        }
        return "redirect:/category/categorypage";

    }



}

