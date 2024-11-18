package ru.gav19770210.javapro.task05.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gav19770210.javapro.task05.entities.Product;
import ru.gav19770210.javapro.task05.repositories.ProductDAO;

import java.util.List;

@Getter
@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public Product getProductById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public List<Product> getUserProducts(Long userId) {
        return productDAO.getAllByUserId(userId);
    }

    public Product createProduct(Product product) {
        return productDAO.create(product);
    }

    public Product updateProduct(Product product) {
        return productDAO.update(product);
    }

    public void deleteProductById(Long id) {
        productDAO.deleteById(id);
    }
}
