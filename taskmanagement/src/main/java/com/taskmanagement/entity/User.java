package com.taskmanagement.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String userName;
    private String password;
    // @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany
    private List<Tasks> tasks;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Tasks> getTasks() {
		return tasks;
	}
	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", tasks=" + tasks + "]";
	}
	public User(Long id, String name, String email, String userName, String password, List<Tasks> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.tasks = tasks;
	}
	public User() {
		super();
	}

    
}
