package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.Entity.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

}
