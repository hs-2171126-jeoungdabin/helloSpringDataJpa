package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.Product;
import kr.ac.hansung.cse.hellospringdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping({"", "/"}) // products 또는 /products/ 둘 다 매핑
    public String viewHomePage(Model model) {

        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @GetMapping("/new")
    public String showNewProductPage(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") Long id, Model model) {

        Product product = service.get(id);
        model.addAttribute("product", product);

        return "edit_product";
    }


@PostMapping("/save")
public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {

    if (result.hasErrors()) {
        
        if (product.getId() != null) { // 수정 상황
            return "edit_product";
        } else { // 신규 등록 상황
            return "new_product"; 
        }
    }
    try {
        service.save(product);
      
    } catch (Exception e) {
      
        model.addAttribute("errorMessage", "상품 저장 중 오류가 발생했습니다: " + e.getMessage());
        // 오류 발생 시, 다시 폼으로 돌아가야 한다면
        if (product.getId() != null) {
            return "edit_product";
        } else {
            return "new_product";
        }
    }
    return "redirect:/products";
}
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {

        service.delete(id);
        return "redirect:/products";
    }
}
