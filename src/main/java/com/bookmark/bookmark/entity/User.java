package com.bookmark.bookmark.entity;

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

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
@Table(name = "users")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
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

    @Column(name = "is_blocked", length = 1, columnDefinition = "boolean  default 0")
    private Boolean blocked;

    @Column(name = "email_token", length = 1, nullable = true, unique = false, columnDefinition = "varchar(100)  default ''")
    private String emailToken;

    @Column(name = "last_login", length = 1, nullable = true, unique = false, columnDefinition = "DateTime")
    private String lastLogin;
    
    @Column(name = "is_deleted", length = 1, columnDefinition = "boolean  default 0")
    private Boolean deleted;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id,
			@NotBlank(message = "Slug is missing.") @Size(min = 3, max = 30, message = "Slug must be between 3 to 30 !!.") String slug,
			@NotBlank(message = "Please enter user Name") @Size(min = 3, max = 12, message = "User Name must be between 3 to 12 !!.") String userName,
			@NotBlank(message = "Please enter name") @Size(min = 3, max = 20, message = "Name must be between 3 to 20 !!.") String name,
			@NotBlank(message = "Email can not be empty !!.") @Size(min = 3, max = 20, message = "Email must be between 3 to 20 !!.") @Email(message = "Please enter correct email address") String email,
			@Size(min = 3, max = 20, message = "Password must be between 3 to 20 !!.") @NotBlank(message = "Please enter password !!.") String password,
			@AssertTrue(message = "please accept term & condition.") Boolean termCondition, Boolean active,
			Boolean blocked, String emailToken, String lastLogin, Boolean deleted, Date created, Date updated) {
		super();
		this.id = id;
		this.slug = slug;
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.password = password;
		this.termCondition = termCondition;
		this.active = active;
		this.blocked = blocked;
		this.emailToken = emailToken;
		this.lastLogin = lastLogin;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", slug=" + slug + ", userName=" + userName + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", termCondition=" + termCondition + ", active=" + active + ", blocked="
				+ blocked + ", emailToken=" + emailToken + ", lastLogin=" + lastLogin + ", deleted=" + deleted
				+ ", created=" + created + ", updated=" + updated + "]";
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getTermCondition() {
		return termCondition;
	}

	public void setTermCondition(Boolean termCondition) {
		this.termCondition = termCondition;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public String getEmailToken() {
		return emailToken;
	}

	public void setEmailToken(String emailToken) {
		this.emailToken = emailToken;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
