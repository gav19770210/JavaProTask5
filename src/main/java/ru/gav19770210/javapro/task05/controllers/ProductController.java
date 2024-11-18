package ru.gav19770210.javapro.task05.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gav19770210.javapro.task05.entities.Product;
import ru.gav19770210.javapro.task05.services.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/get/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        var productGet = productService.getProductById(id);
        if (productGet != null) {
            return productGet;
        } else {
            throw new NoSuchElementException("Не найден продукт с ИД = " + id);
        }
    }

    @GetMapping(value = "/product/get-all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/product/get-by-user/{user_id}")
    public List<Product> getProductByUser(@PathVariable("user_id") Long user_id) {
        return productService.getUserProducts(user_id);
    }

    @PostMapping(value = "/product/create")
    public HttpStatus createProduct(@RequestBody Product product) {
        var productCreate = productService.createProduct(product);
        if (productCreate != null) {
            return HttpStatus.OK;
        } else {
            throw new IllegalArgumentException("Ошибка добавления продукта");
        }
    }

    @PostMapping(value = "/product/update")
    public HttpStatus updateProduct(@RequestBody Product product) {
        var productGet = productService.getProductById(product.getId());
        if (productGet != null) {
            productService.updateProduct(product);
            return HttpStatus.OK;
        } else {
            throw new NoSuchElementException("Не найден продукт с ИД = " + product.getId());
        }
    }

    @DeleteMapping(value = "/product/delete/{id}")
    public HttpStatus deleteProduct(@PathVariable("id") Long id) {
        var productGet = productService.getProductById(id);
        if (productGet != null) {
            productService.deleteProductById(id);
            return HttpStatus.OK;
        } else {
            throw new NoSuchElementException("Не найден продукт с ИД = " + id);
        }
    }
}
