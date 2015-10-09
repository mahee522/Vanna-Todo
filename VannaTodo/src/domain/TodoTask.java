package domain;

import java.util.Date;

public class TodoTask {

	String taskId;
	String categoryId;

	String task;
	String isTaskCompleted;
	Date taskCompletionDate;
	String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getIsTaskCompleted() {
		return isTaskCompleted;
	}

	public void setIsTaskCompleted(String isTaskCompleted) {
		this.isTaskCompleted = isTaskCompleted;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String string) {
		this.taskId = string;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getTaskCompletionDate() {
		return taskCompletionDate;
	}

	public void setTaskCompletionDate(Date taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}

}
