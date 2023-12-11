package codingtest.codingtestspring.repository;

import codingtest.codingtestspring.entity.LoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanHistoryRepository extends JpaRepository<LoanHistory, Integer> {
    // 특정 사용자의 대출 기록 조회
    List<LoanHistory> findByUserId(Integer userId);

    // 특정 책에 대한 대출 기록 조회
    List<LoanHistory> findByBookId(Integer bookId);

    // 대출 상태별 대출 기록 조회
    List<LoanHistory> findByStatus(String status);
}
