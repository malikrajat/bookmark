package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
