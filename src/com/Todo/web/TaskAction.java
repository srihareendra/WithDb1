package com.Todo.web;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.Todo.dao.*;
import com.Todo.domain.Task;

public class TaskAction extends ActionSupport implements ModelDriven<Task> {


	private static final long serialVersionUID = 2150296022787507923L;
	private Task task = new Task();
	private List<Task> taskList = new ArrayList<Task>();
	private TaskDAO taskDAO = new MyTaskDAOImpl();
	 

	public Task getModel() {
		return task;
	}
	
	
	
	public String saveOrUpdate()
	{	
		taskDAO.saveOrUpdateTask(task);
		return SUCCESS;
	}
	
	public String list()
	{
		taskList = taskDAO.listTask();
		return SUCCESS;
	}
	
	public String delete()
	{
		System.out.println(" UserAction-  delete()..  ");
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		taskDAO.deleteTask(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String edit()
	{
		System.out.println(" UserAction-  edit()..  ");
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		task = taskDAO.listTaskById(Long.parseLong(request.getParameter("id")));
		
		return SUCCESS;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	
	
	
}
