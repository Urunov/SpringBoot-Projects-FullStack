package com.urunov.controller.web;

import com.pusher.rest.Pusher;
import com.urunov.constants.GeneralConstants;
import com.urunov.constants.PusherConstants;
import com.urunov.controller.web.vo.ItemRequest;
import com.urunov.model.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * User: hamdamboy
 * Project: card
 * Github: @urunov
 */

@RestController
@SessionAttributes(GeneralConstants.ID_SESSION_SHOPPING_CART)
public class CartController {

    private List<Product> products = new ArrayList<Product>();

    private Pusher pusher;

    @PostConstruct
    public void configure()
    {
        pusher = new Pusher(
                PusherConstants.PUSHER_APP_ID,
                PusherConstants.PUSHER_APP_KEY,
                PusherConstants.PUSHER_APP_SECRET
        );

        pusher.setCluster(PusherConstants.PUSHER_CLUSTER_KEY);
        pusher.setEncrypted(true);

        Product product = new Product();
        product.setId(1L);
        product.setName("Office Chair");
        product.setPrice(new BigDecimal("55.99"));
        products.add(product);

        product = new Product();
        product.setId(2L);
        product.setName("Sunglasses");
        product.setPrice(new BigDecimal("99.99"));
        products.add(product);

        product = new Product();
        product.setId(3L);
        product.setName("Wireless Headphones");
        product.setPrice(new BigDecimal("349.01"));
        products.add(product);

        product = new Product();
        product.setId(4L);
        product.setName("External Hard Drive");
        product.setPrice(new BigDecimal("89.99"));
        products.add(product);
    }

    /**
     * Method that returns the products available for shopping
     *
     * @return List of product objects
     */
    @RequestMapping(value = "/products",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Method that returns the list of products in the current shopping cart
     * @param shoppingCart List of products injected by Spring MVC from the session
     * @return List of products
     */
    @RequestMapping(value = "/cart/items",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<Product> getCartItems(@SessionAttribute(GeneralConstants.ID_SESSION_SHOPPING_CART) List<Product> shoppingCart) {
        return shoppingCart;
    }

    /**
     * Method to add a product to the shopping cart
     * @param request Request object
     * @param shoppingCart List of products injected by Spring MVC from the session
     * @return Status string
     */
    @RequestMapping(value = "/cart/item",
            method = RequestMethod.POST,
            consumes = "application/json")
    public String addItem(@RequestBody ItemRequest request, @SessionAttribute(GeneralConstants.ID_SESSION_SHOPPING_CART) List<Product> shoppingCart) {
        Product newProduct = new Product();
        Optional<Product> optional = getProductById(products.stream(), request.getId());

        if (optional.isPresent()) {
            Product product = optional.get();

            newProduct.setId(product.getId());
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());
            newProduct.setQuantity(request.getQuantity());

            Optional<Product> productInCart = getProductById(shoppingCart.stream(), product.getId());
            String event;

            if(productInCart.isPresent()) {
                productInCart.get().setQuantity(request.getQuantity());
                event = "itemUpdated";
            } else {
                shoppingCart.add(newProduct);
                event = "itemAdded";
            }

            pusher.trigger(PusherConstants.CHANNEL_NAME, event, newProduct);
        }

        return "OK";
    }

    /**
     * Method that deletes an item from the cart
     *
     * @param request Request object
     * @param shoppingCart List of products injected by Spring MVC from the session
     * @return Status string
     */
    @RequestMapping(value = "/cart/item",
            method = RequestMethod.DELETE,
            consumes = "application/json")
    public String deleteItem(@RequestBody ItemRequest request, @SessionAttribute(GeneralConstants.ID_SESSION_SHOPPING_CART) List<Product> shoppingCart) {
        Optional<Product> optional = getProductById(products.stream(), request.getId());

        if (optional.isPresent()) {
            Product product = optional.get();

            Optional<Product> productInCart = getProductById(shoppingCart.stream(), product.getId());

            if(productInCart.isPresent()) {
                shoppingCart.remove(productInCart.get());
                pusher.trigger(PusherConstants.CHANNEL_NAME, "itemRemoved", product);
            }
        }

        return "OK";
    }

    /**
     * Method that empties the shopping cart
     * @param model Object from Spring MVC
     * @return Status string
     */
    @RequestMapping(value = "/cart",
            method = RequestMethod.DELETE)
    public String emptyCart(Model model) {
        model.addAttribute(GeneralConstants.ID_SESSION_SHOPPING_CART, new ArrayList<Product>());
        pusher.trigger(PusherConstants.CHANNEL_NAME, "cartEmptied", "");

        return "OK";
    }

    /**
     * Gets a product by its id from a stream
     * @param stream That contains the product to get
     * @param id Of the product to get
     * @return The product wrapped in an Optional object
     */
    private Optional<Product> getProductById(Stream<Product> stream, Long id) {
        return stream
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}


