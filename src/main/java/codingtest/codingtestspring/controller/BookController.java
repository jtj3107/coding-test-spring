package codingtest.codingtestspring.controller;

import codingtest.codingtestspring.repository.BookRepository;
import codingtest.codingtestspring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // 도서 등록
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // 도서 수정
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        if (bookDetails.getTitle() != null) {
            book.setTitle(bookDetails.getTitle());
        }
        if (bookDetails.getAuthor() != null) {
            book.setAuthor(bookDetails.getAuthor());
        }
        if (bookDetails.getIsbn() != null) {
            book.setIsbn(bookDetails.getIsbn());
        }
        if (bookDetails.getPublishedDate() != null) {
            book.setPublishedDate(bookDetails.getPublishedDate());
        }
        if (bookDetails.getStatus() != null) {
            book.setStatus(bookDetails.getStatus());
        }

        return bookRepository.save(book);
    }

    // 모든 도서 조회
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 특정 도서 조회
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }
}
