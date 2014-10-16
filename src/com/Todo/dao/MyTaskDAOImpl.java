package com.Todo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.Todo.domain.Task;



public class MyTaskDAOImpl implements TaskDAO {
	

	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
  public static long cnt=1;
	/**
	 * Used to save or update a user.
	 */
	public void saveOrUpdateTask(Task task) {
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			session.saveOrUpdate(task);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	public void deleteTask(Long taskId) {
		try {
			Task task = (Task) session.get(Task.class, taskId);
			session.delete(task);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	public List<Task> listTask() {
		List<Task> courses = null;
		try {
			courses = session.createQuery("from Task").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single user by Id.
	 */
	public Task listTaskById(Long taskId) {
		Task task = null;
		try {
			task = (Task) session.get(Task.class, taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

}











