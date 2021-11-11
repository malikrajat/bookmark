package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
