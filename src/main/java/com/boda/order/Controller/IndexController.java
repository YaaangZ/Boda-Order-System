package com.boda.order.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("message", "Hello, world!");
        return "index";
    }
}
