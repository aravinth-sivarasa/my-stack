package io.demo.product.vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UIRestController {
    
    @GetMapping("vue/**")
    public String vue(){
        return "/index.html";
    }

    @GetMapping("")
    public String index(){
        return "index.html";
    }

    //@GetMapping("/error?continue")
    public String error(){
        return "redirect: /vue";
    }
}
