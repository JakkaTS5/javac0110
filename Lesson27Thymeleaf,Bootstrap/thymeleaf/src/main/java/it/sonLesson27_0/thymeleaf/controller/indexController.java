package it.sonLesson27_0.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//1. use annotation controller for MVC full
@Controller
public class indexController {
    //hiện thi đường dẫn
    @GetMapping(value = {"/", "index"})
    public String indexAction(Model model){
        String textStr = "Database";
        model.addAttribute("text",textStr);
        //2. search index trong templates, file index.html exist
        return "index";
    }
}
