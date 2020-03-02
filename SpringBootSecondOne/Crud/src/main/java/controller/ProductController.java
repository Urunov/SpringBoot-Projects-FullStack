package controller;

import model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    //
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProducts(@PathVariable long id){
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
