package io.cuongpq.spring.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "index.html"})
    public String indexAction(Model model) {
        model.addAttribute("text", "aaaa");
        return "index";
    }
}
