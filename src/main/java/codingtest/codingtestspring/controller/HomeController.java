package codingtest.codingtestspring.controller;

import codingtest.codingtestspring.entity.Book;
import codingtest.codingtestspring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Book> books = bookRepository.findAll();

        System.out.println("Books: " + books);
        model.addAttribute("books", books);
        return "home"; // home.html 템플릿 반환
    }
}
