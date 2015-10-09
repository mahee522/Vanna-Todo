package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vanna.excp.DAOException;

import domain.TodoCategory;
import domain.TodoTask;

public interface TodoDAO {
	public TodoCategory addCategory(TodoCategory _category) throws DAOException;
	public ArrayList<TodoCategory> listAllCategorys(String _userId);
	public TodoCategory deleteCategory(TodoCategory deleteCategory);
	public TodoCategory deleteAllCategorys(TodoCategory deleteAllCategorys);
	public TodoTask addTask(TodoTask addTask);
	public TodoTask upDateTask(TodoTask updateTask);
	public TodoTask deleteTask(TodoTask deleteTask);
	public ArrayList<TodoTask> listAllTasks(TodoTask listAllTasks) throws SQLException;
	public TodoTask deleteAllTasks(TodoTask deleteAllTasks);
}
