package codingtest.codingtestspring.repository;

import codingtest.codingtestspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // 필요한 쿼리 메소드
}
