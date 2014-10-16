package com.Todo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
@Entity
@Table(name ="Task")
public class Task {
	private  Long id;
	private String task_name;
	private String priority;
	private String status;
	private String duedate;
	
	@Id
	@GeneratedValue
	
	@Column(name="TASK_ID")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message ="enter name")
	@Column(name="TASK_NAME")
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	@NotEmpty(message ="enter priority")
	@Column(name="TASK_Priority")
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	@NotEmpty(message ="enter Date")
	@Column(name="TASK_Duedate")
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	
	
	@NotEmpty(message ="enter status")
	@Column(name="TASK_Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
