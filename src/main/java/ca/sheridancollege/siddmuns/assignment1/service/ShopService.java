package ca.sheridancollege.siddmuns.assignment1.service;

import ca.sheridancollege.siddmuns.assignment1.model.Inventory;
import ca.sheridancollege.siddmuns.assignment1.model.Product;
import ca.sheridancollege.siddmuns.assignment1.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


public interface ShopService {
    public int getRandomId();

    public void addProductToShoppingCart(int id);

    public void insertProductToInventory(Product product);

    public int getCartCapacity();


    public List<Product> getAllProducts();

    public List<Product> getShoppingCart();
}
