package com.bookmark.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.entity.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

}
