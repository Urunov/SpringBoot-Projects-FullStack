package service;

import model.Products;

import java.util.List;

public interface ProductService {
    //
    Products createProduct(Products products);

    Products updateProduct(Products products);

    List<Products> getAllProducts();

    Products getProductById(long productId);

    void deleteProduct(long id);
}
