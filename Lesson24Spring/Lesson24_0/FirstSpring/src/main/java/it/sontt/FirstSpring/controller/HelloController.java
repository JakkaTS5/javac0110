package it.sontt.FirstSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class HelloController {
    @GetMapping(value = "hello")
    public String getHelloAction() {
        return "hello moi nguoi";
    }
    @GetMapping(value = "about")
    public String getAboutAction() {
        return "about";
    }
}
