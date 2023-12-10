package codingtest.codingtestspring.repository;

import codingtest.codingtestspring.entity.LoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanHistoryRepository extends JpaRepository<LoanHistory, Integer> {
    // 필요한 쿼리 메소드
}
