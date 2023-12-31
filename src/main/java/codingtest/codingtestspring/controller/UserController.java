// UserController.java
package codingtest.codingtestspring.controller;

import codingtest.codingtestspring.entity.User;
import codingtest.codingtestspring.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            session.setAttribute("user", foundUser.get());
            return "redirect:/home"; // 성공 시 홈 페이지로 리디렉션
        } else {
            return "redirect:/login?error"; // 실패 시 로그인 페이지로 리디렉션
        }
    }
}
