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
@Table(name = "bookmarks")
@Data
public class BookMark implements Serializable {

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

    @Column(nullable = false, unique = false, length = 100, columnDefinition = "varchar(100)  default ''")
    @NotBlank(message = "Please enter URL")
    @Size(min = 3, max = 20, message = "Title must be between 3 to 20 !!.")
    private String url;

    @Column(nullable = true, unique = false, length = 100, columnDefinition = "varchar(255)  default ''")
    @NotBlank(message = "Please enter description")
    @Size(min = 3, max = 200, message = "Title must be between 3 to 200 !!.")
    private String description;

    @Column(name = "user_id")
    @NotBlank(message = "User is missing.")
    // private User user;
    private long user;

    @Column(name = "collection_id")
    @NotBlank(message = "collection is missing.")
    // private Collection collection;
    private long collection;

    @Column(name = "category_id")
    @NotBlank(message = "category is missing.")
    // private Category category;
    private long category;

    @Column(columnDefinition = "bigint(20)")
    @NotBlank(message = "Position is missing.")
    private Boolean position;

    @Column(name = "is_deleted", length = 1, columnDefinition = "boolean  default 0")
    private Boolean deleted;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;
    
    

    public BookMark(long id,
            @NotBlank(message = "Slug is missing.") @Size(min = 3, max = 30, message = "Slug must be between 3 to 30 !!.") String slug,
            @NotBlank(message = "Please enter title") @Size(min = 3, max = 20, message = "Title must be between 3 to 20 !!.") String title,
            @NotBlank(message = "Please enter URL") @Size(min = 3, max = 20, message = "Title must be between 3 to 20 !!.") String url,
            @NotBlank(message = "Please enter description") @Size(min = 3, max = 200, message = "Title must be between 3 to 200 !!.") String description,
            @NotBlank(message = "User is missing.") long user,
            @NotBlank(message = "collection is missing.") long collection,
            @NotBlank(message = "category is missing.") long category,
            @NotBlank(message = "Position is missing.") Boolean position, Boolean deleted, Date created, Date updated) {
        super();
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.url = url;
        this.description = description;
        this.user = user;
        this.collection = collection;
        this.category = category;
        this.position = position;
        this.deleted = deleted;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BookMark [category=" + category + ", collection=" + collection + ", created=" + created + ", deleted="
                + deleted + ", description=" + description + ", id=" + id + ", position=" + position + ", slug=" + slug
                + ", title=" + title + ", updated=" + updated + ", url=" + url + ", user=" + user + "]";
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public Boolean getPosition() {
        return position;
    }

    public void setPosition(Boolean position) {
        this.position = position;
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

	public BookMark() {
		super();
		// TODO Auto-generated constructor stub
	}

}
