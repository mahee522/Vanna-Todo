package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.transaction.UniqueIdTest;
import com.vanna.excp.DAOException;

import domain.TodoCategory;
import domain.TodoTask;

/**
 * 
 * @author MAHI
 *
 */
public class TodoDAOImplematation implements TodoDAO {

	/**
	 * 
	 * @param _category
	 * @return
	 * @throws DAOException 
	 */

	public TodoCategory addCategory(TodoCategory _category) throws DAOException {
		String categorySql = "INSERT INTO TODOCATEGORY(CATEGORYID,USERID,CATEGORY,CATEGORYDESC) VALUES('"
				+ UniqueIdTest.uniquId() + "','" + _category.getUserId() + "','" + _category.getCategory() + "','"
				+ _category.getCategoryDesc() + "')";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement stmt = con.createStatement();
			stmt.executeQuery(categorySql);

			
		} catch (SQLException sqx) {
			throw new DAOException("Unable to add Category. ", sqx);

		} catch (ClassNotFoundException cnx) {
			throw new DAOException("Could not connect to Database. ", cnx);

		}

		return _category;
	}

	public static ArrayList<TodoCategory> listAllCategorys(String _userId) {

		ArrayList<TodoCategory> _listAllCategorys = new ArrayList<TodoCategory>();
		try {
			String sql = "select CATEGORY from TODOCATEGORY where USERID='" + _userId + "'";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			
			int i = 0;
			while (rs.next()) {
				TodoCategory _category = new TodoCategory();
				_category.setCategory(rs.getString("CATEGORY"));
				_listAllCategorys.add(i, _category);
				i++;
			}
			con.close();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return _listAllCategorys;
	}

	public TodoCategory deleteCategory(TodoCategory deleteCategory) {
		try {
			System.out.println(" enter dao deletecategory method:");
			String sql = "DELETE FROM TodoCategory WHERE category='" + deleteCategory.getCategory() + "' AND userid='"
					+ deleteCategory.getUserId() + "'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("deleted result: " + i);
			con.close();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return deleteCategory;
	}

	public TodoCategory deleteAllCategorys(TodoCategory deleteAllCategorys) {
		try {
			System.out.println(" enter dao delete all categorys method:");
			String sql = "DELETE FROM ToDoCategory WHERE userid='" + deleteAllCategorys.getUserId() + "'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("deleted result: " + i);
			con.close();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return deleteAllCategorys;
	}

	public TodoTask addTask(TodoTask addTask) {
		try {
			String sql = "insert into TODOTASK VALUES('" + addTask.getCategoryId() + "','" + addTask.getTaskId()
					+ "','" + addTask.getTask() + "','" + addTask.getIsTaskCompleted() + "')";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();
			stmt.executeQuery(sql);
			con.close();

		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return addTask;
	}

	public TodoTask upDateTask(TodoTask updateTask) {
		try {
			System.out.println("Enterd into update task method");

			String sql = "update TODOTASK set TASK='" + updateTask.getTask() + "' WHERE taskid= '"
					+ updateTask.getTaskId() + "'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("updated table result: " + i);
		} catch (Exception ae) {
			ae.printStackTrace();
		}

		return updateTask;

	}

	public TodoTask deleteTask(TodoTask deleteTask) {
		System.out.println("Enterd into delete task method");
		try {
			String sql = "delete from TODOTASK where TASKID='" + deleteTask.getTaskId() + "' and CATEGORYID='"
					+ deleteTask.getCategoryId() + "'";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);

			System.out.println("delete task method executed" + i);
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return deleteTask;
	}

	public ArrayList<TodoTask> listAllTasks(TodoTask listAllTasks) throws SQLException {
		ArrayList<TodoTask> _toTasks = new ArrayList<TodoTask>();
		Connection con = null;
		try {
			String sql = "select TASK,ISCOMPLETED from TODOTASK where CATEGORYID='" + listAllTasks.getCategoryId()
					+ "'";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			String _categoryName = listAllTasks.getCategoryName();
			TodoTask _toTodoTask = new TodoTask();
			_toTodoTask.setCategoryName(_categoryName);
			int i = 0;
			while (rs.next()) {

				_toTodoTask.setTask(rs.getString("TASK"));
				_toTodoTask.setIsTaskCompleted(rs.getString("ISCOMPLETED"));
				_toTasks.add(i, _toTodoTask);
				i++;
			}
		
		} catch (Exception se) {
			se.printStackTrace();
		}
		finally{
			
			con.close();
		}
		return _toTasks;
	}
	public TodoTask deleteAllTasks(TodoTask deleteAllTasks) {
		try {

			String sql = "delete from TODOTASK where CATEGORYID='" + deleteAllTasks.getCategoryId() + "'";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("delete all tasks result: " + i);
			con.close();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return deleteAllTasks;
	}

	public static String getCategoryID(TodoCategory _TodoCategory) {

		String cid = null;
		try {

			String sql = "select CATEGORYID from todocategory where CATEGORY='" + _TodoCategory.getCategory() + "'";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				cid = rs.getString("CATEGORYID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cid;

	}

	public static String getTaskID(TodoTask _TodoTask) {

		String _taskid = null;
		try {
			String sql = "select TASKID from todotask where TASK='" + _TodoTask.getTask() + "'";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				_taskid = rs.getString("TASKID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return _taskid;

	}

}
