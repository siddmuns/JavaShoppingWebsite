package ca.sheridancollege.siddmuns.assignment1.service;

import ca.sheridancollege.siddmuns.assignment1.model.Inventory;
import ca.sheridancollege.siddmuns.assignment1.model.Product;
import ca.sheridancollege.siddmuns.assignment1.model.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ShopServiceImpl implements ShopService {
    private final Inventory inventory = new Inventory();
    private final ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public int getRandomId() {
        Random random = new Random();
        int randId;
        randId = random.nextInt(100000000,999999999);
        return randId;
    }

    @Override
    public void addProductToShoppingCart(int id) {
        Product newItem = inventory.getProductById(id);
        shoppingCart.insertItemToCart(newItem);
    }

    @Override
    public void insertProductToInventory(Product product) {
        inventory.insertProduct(product);
    }

    @Override
    public int getCartCapacity() {
        return shoppingCart.getCapacity();
    }

    @Override
    public float getSubTotal() {
        return shoppingCart.getSubTotal();
    }

    @Override
    public float getSalesTax() {
        float salesTax = shoppingCart.getSubTotal();
        salesTax *= 0.13F;
        return salesTax;
    }

    @Override
    public float getTotal() {
        return getSubTotal() + getSalesTax();
    }

    @Override
    public List<Product> getAllProducts() {
        return inventory.getProducts();
    }

    @Override
    public List<Product> getShoppingCart() {
        return shoppingCart.getCartItems();
    }
}
