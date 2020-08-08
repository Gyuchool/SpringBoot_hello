package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")//domain 첫번째 / 오면 호출
    public String home(){
        return "home";//home.html 호출
    }
}
