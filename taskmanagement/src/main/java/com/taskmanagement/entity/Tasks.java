package com.taskmanagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private String importance;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", name=" + name + ", status=" + status + ", importance=" + importance + "]";
	}
	public Tasks(Long id, String name, String status, String importance) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.importance = importance;
	}
	public Tasks() {
		super();
	} 
    
    
}
