package ru.gav19770210.javapro.task05.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gav19770210.javapro.task05.entities.Product;
import ru.gav19770210.javapro.task05.services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{id}/get")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping(value = "/product/get-all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/product/{user_id}/get-by-user")
    public List<Product> getProductByUser(@PathVariable("user_id") Long user_id) {
        return productService.getUserProducts(user_id);
    }

    @PostMapping(value = "/product/create")
    public HttpStatus createProduct(@RequestBody Product product) {
        var productCreate = productService.createProduct(product);
        return HttpStatus.OK;
    }

    @PostMapping(value = "/product/update")
    public HttpStatus updateProduct(@RequestBody Product product) {
        var productUpdate = productService.updateProduct(product);
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/product/{id}/delete")
    public HttpStatus deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return HttpStatus.OK;
    }
}
