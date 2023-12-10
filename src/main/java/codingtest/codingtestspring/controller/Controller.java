package codingtest.codingtestspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String Home() {
        return "Welcome to the Spring Boot application!";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html 템플릿을 반환
    }
}
