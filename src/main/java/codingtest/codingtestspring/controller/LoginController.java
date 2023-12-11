package codingtest.codingtestspring.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html 템플릿을 반환
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션 무효화
        session.invalidate();

        // 로그아웃 후 리디렉션할 페이지 (예: 로그인 페이지)
        return "redirect:/Home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // signup.html 템플릿 반환
    }
}
