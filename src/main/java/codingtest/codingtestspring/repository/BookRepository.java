package codingtest.codingtestspring.repository;

import codingtest.codingtestspring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // 필요한 쿼리 메소드
}
