package com.transaction;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vanna.excp.DAOException;
import com.vanna.excp.VannaBusinessException;

import dao.TodoDAOImplematation;
import domain.TodoCategory;
import domain.TodoTask;

/**
 * @author MAHI
 *
 */
public class TodoTrxAction {

	public void process(HttpServletRequest request, HttpServletResponse response) throws VannaBusinessException,
			DAOException, SQLException {

		String __action = request.getParameter("_action");
		//String _action="loginAction";
		String _userId = request.getParameter("userId");
		
		ArrayList<TodoCategory> catList = new ArrayList<TodoCategory>();
		ArrayList<TodoTask> taskList = new ArrayList<TodoTask>();
		
		if(__action.equalsIgnoreCase("loginAction")){
			
			catList = TodoDAOImplematation.listAllCategorys(_userId);
			request.setAttribute("categoryList", catList);
				
		}else if(__action.equalsIgnoreCase("addCategory")) {// TODO add category action
			// TODO Validations
			TodoCategory _category = new TodoCategory();
			String _catName = request.getParameter("category");
			_category.setCategory(_catName);
			_category.setCategoryDesc(request.getParameter("categoryDesc"));
			_category.setUserId(request.getParameter("userId"));
			String _categoryId = UniqueIdTest.uniquId();
			_category.setCategoryId(_categoryId);

			TodoDAOImplematation.addCategory(_category);
			catList = TodoDAOImplematation.listAllCategorys(_userId);
			request.setAttribute("categoryList", catList);

			request.setAttribute("result", _category);
			request.setAttribute("nextPage", "home.jsp");
		}

		// TODO list out all categories action
		else if (__action.equalsIgnoreCase("listAllCategorys")) {
			//String _userId="aaa";
			if (_userId != null) {

				catList = TodoDAOImplematation.listAllCategorys(_userId);

			} else {
				throw new VannaBusinessException("UserId must be given to get all categories list");
			}
			request.setAttribute("categoryList", catList);

		}

		// TODO delete category action
		else if (__action.equalsIgnoreCase("deleteCategory")) {
			String _category = request.getParameter("deleteCategory");

			if (_userId != null) {
				TodoCategory _categoryObj = new TodoCategory();
				_categoryObj.setCategory(_category);
				_categoryObj.setUserId(_userId);
				TodoDAOImplematation.deleteCategory(_categoryObj);
				System.out.println("delete transaction called from transaction class");
			}
		}

		// TODO delete all categories action
		else if (__action.equalsIgnoreCase("deleteAllCategorys")) {
			if (_userId != null) {
				TodoCategory _categoryObj = new TodoCategory();
				_categoryObj.setUserId(_userId);
				TodoDAOImplematation.deleteAllCategorys(_categoryObj);
			}
		}

		// TODO list out all tasks action
		else if (__action.equalsIgnoreCase("listAllTasks")) {
			String _category = request.getParameter("category");

			TodoCategory _TodoCategory = new TodoCategory();
			_TodoCategory.setCategory(_category);
			String _categoryId = TodoDAOImplematation.getCategoryID(_TodoCategory);
			TodoTask _TodoTask = new TodoTask();
			if (_categoryId != null) {

				_TodoTask.setCategoryId(_categoryId);

				taskList = TodoDAOImplematation.listAllTasks(_TodoTask);
			} else {
				throw new VannaBusinessException("Category must given");
			}
			request.setAttribute("taskList", taskList);
		}

		// TODO updateTask action
		else if (__action.equalsIgnoreCase("updateTask")) {
			TodoTask _toTodoTask = new TodoTask();

			String _etask = request.getParameter("existtask");
			String _utask = request.getParameter("updatetask");

			_toTodoTask.setTask(_etask);
			String _taskId = TodoDAOImplematation.getTaskID(_toTodoTask);
			System.out.println(_taskId);

			if (_taskId != null) {
				TodoTask _taskObj = new TodoTask();
				_taskObj.setTask(_utask);
				_taskObj.setTaskId(_taskId);

				TodoDAOImplematation.upDateTask(_taskObj);
			} else {
				System.out.println("Updation failed");
			}
		}
		// TODO addTask action
		else if (__action.equalsIgnoreCase("addTask")) {
			TodoTask _task = new TodoTask();

			TodoCategory _TodoCategory = new TodoCategory();

			_TodoCategory.setCategory(request.getParameter("category"));

			String _categoryId = TodoDAOImplematation.getCategoryID(_TodoCategory);

			_task.setCategoryId(_categoryId);

			String _taskId = UniqueIdTest.uniquId();
			_task.setTaskId(_taskId);

			_task.setTask(request.getParameter("task"));

			_task.setIsTaskCompleted(request.getParameter("isTaskCompleted"));

			TodoDAOImplematation.addTask(_task);
			request.setAttribute("_task", _task);

		}

		// TODO delete task action
		else if (__action.equalsIgnoreCase("deleteTask")) {
			System.out.println("todotrxaction delete method");
			String _task = request.getParameter("deleteTask");
			String _category = request.getParameter("category");

			TodoTask _toTask = new TodoTask();
			_toTask.setTask(_task);

			String _taskId = TodoDAOImplematation.getTaskID(_toTask);
			System.out.println("TASK ID " + _taskId);

			TodoCategory _tCategory = new TodoCategory();
			_tCategory.setCategory(_category);

			String _categoryId = TodoDAOImplematation.getCategoryID(_tCategory);
			System.out.println("CATEGORY ID: " + _categoryId);

			if (_taskId != null && _categoryId != null) {
				TodoTask _taskObj = new TodoTask();
				_taskObj.setCategoryId(_categoryId);
				_taskObj.setTaskId(_taskId);
				TodoDAOImplematation.deleteTask(_taskObj);
			}

		}

		// TODO delete all categories action
		else if (__action.equalsIgnoreCase("deleteAllTasks")) {
			TodoCategory _toCategory = new TodoCategory();

			String _category = request.getParameter("category");
			_toCategory.setCategory(_category);

			String _categoryId = TodoDAOImplematation.getCategoryID(_toCategory);
			if (_categoryId != null) {
				TodoTask _TodoTask = new TodoTask();
				_TodoTask.setCategoryId(_categoryId);

				TodoDAOImplematation.deleteAllTasks(_TodoTask);
			}
		}
		
		}


}
