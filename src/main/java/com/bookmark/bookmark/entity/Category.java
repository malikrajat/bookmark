package com.bookmark.bookmark.entity;

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
@Table(name = "categories")
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @NotNull
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "Slug is missing.")
    @Size(min = 3, max = 30, message = "Slug must be between 3 to 30 !!.")
    private String slug;

    @Column(nullable = false, unique = false, length = 100, columnDefinition = "varchar(100)  default ''")
    @NotBlank(message = "Please enter title")
    @Size(min = 3, max = 20, message = "Title must be between 3 to 20 !!.")
    private String title;

    @Column(name = "user_id", columnDefinition = "bigint(20)")
    @NotBlank(message = "User is missing.")
    // private User user;
    private long user;

    @Column(name = "collection_id")
    @NotBlank(message = "collection is missing.")
    // private Collection collection;
    private long collection;

    @Column(columnDefinition = "bigint(20)")
    @NotBlank(message = "Position is missing.")
    private Boolean position;

    @Column(columnDefinition = "varchar(20)")
    @NotBlank(message = "Color is missing.")
    private String color;

    @Column(name = "is_deleted", length = 1, columnDefinition = "boolean  default 0")
    private Boolean deleted;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    public Category(long id,
            @NotBlank(message = "Slug is missing.") @Size(min = 3, max = 30, message = "Slug must be between 3 to 30 !!.") String slug,
            @NotBlank(message = "Please enter title") @Size(min = 3, max = 20, message = "Title must be between 3 to 20 !!.") String title,
            @NotBlank(message = "User is missing.") long user,
            @NotBlank(message = "collection is missing.") long collection,
            @NotBlank(message = "Position is missing.") Boolean position,
            @NotBlank(message = "Color is missing.") String color, Boolean deleted, Date created, Date updated) {
        super();
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.user = user;
        this.collection = collection;
        this.position = position;
        this.color = color;
        this.deleted = deleted;
        this.created = created;
        this.updated = updated;
    }

    public Category() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", slug=" + slug + ", title=" + title + ", user=" + user + ", collection="
                + collection + ", position=" + position + ", color=" + color + ", deleted=" + deleted + ", created="
                + created + ", updated=" + updated + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getCollection() {
        return collection;
    }

    public void setCollection(long collection) {
        this.collection = collection;
    }

    public Boolean getPosition() {
        return position;
    }

    public void setPosition(Boolean position) {
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}
