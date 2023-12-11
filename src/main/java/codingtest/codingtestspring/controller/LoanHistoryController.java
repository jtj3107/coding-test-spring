package codingtest.codingtestspring.controller;

import codingtest.codingtestspring.repository.BookRepository;
import codingtest.codingtestspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import codingtest.codingtestspring.repository.LoanHistoryRepository;
import codingtest.codingtestspring.entity.LoanHistory;
import codingtest.codingtestspring.entity.User;
import codingtest.codingtestspring.entity.Book;
import java.util.List;

@RestController
@RequestMapping("/loanHistory")
public class LoanHistoryController {

    // 대출 기록 등록

    @Autowired
    private LoanHistoryRepository loanHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    // 대출 기록 등록
    @PostMapping
    public LoanHistory addLoanHistory(@RequestBody LoanHistory loanHistory,
                                      @RequestParam Integer userId,
                                      @RequestParam Integer bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + bookId));

        loanHistory.setUser(user);
        loanHistory.setBook(book);
        return loanHistoryRepository.save(loanHistory);
    }

    // 모든 대출 기록 조회
    @GetMapping
    public List<LoanHistory> getAllLoanHistories() {
        return loanHistoryRepository.findAll();
    }

    // 특정 대출 기록 조회
    @GetMapping("/{id}")
    public LoanHistory getLoanHistoryById(@PathVariable Integer id) {
        return loanHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LoanHistory not found with id " + id));
    }

    // 대출 처리 (대출 기록 업데이트)
    @PutMapping("/loan/{id}")
    public LoanHistory loanBook(@PathVariable Integer id, @RequestBody LoanHistory loanHistoryDetails) {
        LoanHistory loanHistory = loanHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LoanHistory not found with id " + id));
        loanHistory.setReturnDate(loanHistoryDetails.getReturnDate());
        loanHistory.setStatus("Loaned");
        return loanHistoryRepository.save(loanHistory);
    }

    // 반납 처리 (대출 기록 업데이트)
    @PutMapping("/return/{id}")
    public LoanHistory returnBook(@PathVariable Integer id, @RequestBody LoanHistory loanHistoryDetails) {
        LoanHistory loanHistory = loanHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LoanHistory not found with id " + id));
        loanHistory.setReturnDate(loanHistoryDetails.getReturnDate());
        loanHistory.setStatus("Returned");
        return loanHistoryRepository.save(loanHistory);
    }
}
