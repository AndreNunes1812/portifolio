package br.com.portifolio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String getAllMenu() {
        return "menu";
    }
}