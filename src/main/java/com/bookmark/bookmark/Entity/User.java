package com.bookmark.bookmark.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User implements Serializable {

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

    @Column(name = "user_name", nullable = false, unique = true, length = 100, columnDefinition = "varchar(50)  default ''")
    @NotBlank(message = "Please enter user Name")
    @Size(min = 3, max = 12, message = "User Name must be between 3 to 12 !!.")
    private String userName;

    @Column(nullable = false, unique = false, length = 100, columnDefinition = "varchar(100)  default ''")
    @NotBlank(message = "Please enter name")
    @Size(min = 3, max = 20, message = "Name must be between 3 to 20 !!.")
    private String name;

    @Column(nullable = false, unique = true, length = 100, columnDefinition = "varchar(100)  default ''")
    @NotBlank(message = "Email can not be empty !!.")
    @Size(min = 3, max = 20, message = "Email must be between 3 to 20 !!.")
    @Email(message = "Please enter correct email address")
    private String email;

    @Size(min = 3, max = 20, message = "Password must be between 3 to 20 !!.")
    @NotBlank(message = "Please enter password !!.")
    @Column(nullable = false, unique = false, length = 100, columnDefinition = "varchar(100)  default ''")
    private String password;

    @Column(name = "term_condition", length = 1, columnDefinition = "boolean  default false")
    @AssertTrue(message = "please accept term & condition.")
    private Boolean termCondition;

    @Column(name = "is_active", length = 1, columnDefinition = "boolean  default 0")
    private Boolean active;

    @Column(name = "is_deleted", length = 1, columnDefinition = "boolean  default 0")
    private Boolean deleted;

    @Column(name = "is_blocked", length = 1, columnDefinition = "boolean  default 0")
    private Boolean blocked;

    @Column(name = "email_token", length = 1, nullable = true, unique = false, columnDefinition = "varchar(100)  default ''")
    private String emailToken;

    @Column(name = "last_login", length = 1, nullable = true, unique = false, columnDefinition = "DateTime")
    private String lastLogin;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

}
