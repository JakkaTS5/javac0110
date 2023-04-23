package it.sonLesson27_0.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//1. use annotation controller for MVC full
@Controller
public class indexController {
    @GetMapping(value = {"/", "index.html"})
    public String indexAction(Model model){
        String textStr = "hello everyone viet de";
        model.addAttribute("text",textStr);
        //2. search index trong templates, file index.html exist
        return "index";
    }
}
