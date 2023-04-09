package io.cuongpq.spring.thymeleaf.controlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//1. Sử dụng annonation @Controller cho mô hình MVC full
@Controller
public class IndexController {

    @Value("${template.html.title}")
    String title;

    @GetMapping(value = {"/", "index.html"})
    public String indexAction(Model model) {

        System.out.println(title);

        //Logic xử lý xong thì định nghĩa dữ liệu để gắn vào view
        model.addAttribute("title", title);

        //2. Make sure tồn tại file index.html trong thư mục resources/templates
        return "index";
    }
}
