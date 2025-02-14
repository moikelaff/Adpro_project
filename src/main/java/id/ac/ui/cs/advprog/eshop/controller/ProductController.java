package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "ProductList";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        service.addProduct(product);
        return "redirect:/product/list";
    }
}
