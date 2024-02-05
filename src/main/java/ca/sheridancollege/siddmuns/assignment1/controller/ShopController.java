package ca.sheridancollege.siddmuns.assignment1.controller;

import ca.sheridancollege.siddmuns.assignment1.model.Product;
import ca.sheridancollege.siddmuns.assignment1.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopController {

    private final Logger log = LoggerFactory.getLogger(ShopController.class);

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        log.trace("index() is called");
        return new ModelAndView("index");
    }

    @GetMapping("/product")
    public ModelAndView product() {
        log.trace("product() is called");
        List<Product> productList = shopService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("randomId", shopService.getRandomId());
        return modelAndView;
    }

    @PostMapping("/addProduct")
    public ModelAndView addProduct(@ModelAttribute Product product) {
        log.trace("addProduct() is called with: {}", product);
        shopService.insertProductToInventory(product);
        List<Product> productList = shopService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("randomId", shopService.getRandomId());
        return modelAndView; // Redirect after post to prevent double submission
    }

    @GetMapping("/shopping")
    public ModelAndView shopping() {
        log.trace("shopping() is called");
        List<Product> productList = shopService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("shopping");
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("capacity", shopService.getCartCapacity());
        return modelAndView;
    }

    @PostMapping("/addToCart")
    public ModelAndView addToCart(@RequestParam("productId") Integer id) {
        log.trace("addToCart() is called with: {}", id);
        shopService.addProductToShoppingCart(id);
        List<Product> productList = shopService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("shopping");
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("capacity", shopService.getCartCapacity());
        return modelAndView; // Redirect after post to prevent double submission
    }

    @GetMapping("/checkout")
    public ModelAndView checkout() {
        log.trace("checkout() is called");
        return new ModelAndView("shopping");
    }
}
