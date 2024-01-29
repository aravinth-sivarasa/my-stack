package io.demo.restservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIRestController {
    
    @GetMapping("vue/**")
    public String vue(){
        return "/index.html";
    }
}
