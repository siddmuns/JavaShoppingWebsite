package ca.sheridancollege.siddmuns.assignment1.controller;

import ca.sheridancollege.siddmuns.assignment1.model.Product;
import ca.sheridancollege.siddmuns.assignment1.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return new ModelAndView("product");
    }

    @GetMapping("/shopping")
    public ModelAndView shopping() {
        log.trace("shopping() is called");
        return new ModelAndView("shopping");
    }

    @GetMapping("/checkout")
    public ModelAndView checkout() {
        log.trace("checkout() is called");
        return new ModelAndView("shopping");
    }


}
