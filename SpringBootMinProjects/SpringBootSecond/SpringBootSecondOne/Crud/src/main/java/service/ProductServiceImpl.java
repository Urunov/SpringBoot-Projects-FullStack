package service;


import exception.ResourceNotFoundException;
import model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    //

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Products createProduct(Products products) {
        return productRepository.save(products);
    }

    @Override
    public Products updateProduct(Products products) {
        //
        Optional<Products> productDb = this.productRepository.findById(products.getId());

        if(productDb.isPresent()) {
            Products productUpdate = productDb.get();
            productUpdate.setId(products.getId());
            productUpdate.setName(products.getName());
            productUpdate.setDescription(products.getDescription());
            productRepository.save(productUpdate);
            return products;
        } else {
            throw new ResourceNotFoundException("Record id is not found: " + products.getId());

        }
    }

    @Override
    public List<Products> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Products getProductById(long productId) {

        Optional<Products> productsDb = this.productRepository.findById(productId);

        if(productsDb.isPresent()) {
          return productsDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found id: " + productId);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        //
        Optional<Products> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()){
            this.productRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Resource is not found: " + productId);
        }
    }


}
