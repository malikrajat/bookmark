package com.bookmark.bookmark.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "collections")
@Data
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @NotNull
    long id;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "Slug is missing.")
    @Size(min = 3, max = 30, message = "Slug must be between 3 to 30 !!.")
    private String slug;

    @Column(nullable = false, unique = false, length = 100, columnDefinition = "varchar(100)  default ''")
    @NotBlank(message = "Please enter title")
    @Size(min = 3, max = 20, message = "Title must be between 3 to 20 !!.")
    private String title;

    @Column(name = "is_deleted", length = 1, columnDefinition = "boolean  default 0")
    private Boolean deleted;

    @Column(length = 255, columnDefinition = "integer(100)")
    @NotBlank(message = "Position is missing.")
    private Boolean position;

    @Column(name = "user_id")
    @NotBlank(message = "User is missing.")
    private User user;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

}
