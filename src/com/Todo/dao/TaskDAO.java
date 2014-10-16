package com.Todo.dao;

import java.util.List;

import com.Todo.domain.Task;

public interface TaskDAO {

	public void saveOrUpdateTask(Task task);
	public List<Task> listTask();
	public Task listTaskById(Long taskId);
	public void deleteTask(Long taskId);
}
