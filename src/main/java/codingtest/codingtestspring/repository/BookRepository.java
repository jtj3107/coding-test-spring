package codingtest.codingtestspring.repository;

import codingtest.codingtestspring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // 특정 상태의 도서 조회
    List<Book> findByStatus(String status);

    // 제목으로 도서 검색
    List<Book> findByTitleContaining(String title);

    // 저자 이름으로 도서 검색
    List<Book> findByAuthorContaining(String author);

    // ISBN으로 도서 검색
    Book findByIsbn(String isbn);
}
