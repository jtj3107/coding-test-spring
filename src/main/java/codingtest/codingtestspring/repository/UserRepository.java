// UserRepository.java
package codingtest.codingtestspring.repository;

import codingtest.codingtestspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    default User signup(User user) {
        // user.setPassword("temporaryPassword"); // 임시 비밀번호 설정
        return save(user);
    }

    Optional<User> findByUsername(String username);
}
