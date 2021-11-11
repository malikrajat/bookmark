package com.bookmark.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.entity.BookMark;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {

}
