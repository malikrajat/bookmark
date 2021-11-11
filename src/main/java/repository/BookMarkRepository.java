package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.Entity.BookMark;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {

}
