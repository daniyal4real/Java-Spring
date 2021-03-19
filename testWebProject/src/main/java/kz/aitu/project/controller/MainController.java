package kz.aitu.project.controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/products")
    public String productsPage() {
        return "products";
    }

    @RequestMapping("/orders")
    public String ordersPage(){
        return "orders";
    }

    @RequestMapping("/factory")
    public String factoryPage(){
        return "factory";
    }
}
