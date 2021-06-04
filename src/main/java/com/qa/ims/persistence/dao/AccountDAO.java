package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Account;
import com.qa.ims.utils.DBUtils;

//used CustomerDAO.Java for reference and setup//

public abstract class AccountDAO implements Dao<AccountDAO> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Account modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String firstName = resultSet.getString("user_name");
		String password = resultSet.getString("password");
		Boolean isManager = resultSet.getBoolean("is_manager");
		return new Account(id,firstName,password,isManager);
	}
	public Boolean boolFromResultSet(ResultSet resultSet) throws SQLException {
		return resultSet.getBoolean("is_manager");
	}
	
	/**
	 * Reads all customers from the database
	 * 
	 * 
	 * @return A Boolean which states whether the account is an Operations
	 */
	
	public Boolean logIn(String userName,String password) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select is_manager from accounts WHERE user_name ='"+userName+"' and password = '"+password+"'");) {
					resultSet.next();
					return boolFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}

	/**
	 * Reads all accounts from the database
	 * 
	 * @return A list of accounts
	 */
	@Override
	public List<AccountDAO> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from accounts");) {
			List<AccountDAO> accounts = new ArrayList<>();
			while (resultSet.next()) {
				accounts.add(modelFromResultSet(resultSet));
			}
			return accounts;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Account readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an account in the database
	 * 
	 * @param account - takes in an account object. id will be ignored
	 */
	public Account create(Account account) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO accounts(user_name, password,is_manager) values('" + account.getUserName()
					+ "','" + account.getPassword() + "'," + account.getIsManagerInt() +")");
			return readLatest.next();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Account readAccount(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts where id = " + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an account in the database
	 * 
	 * @param account - takes in an account object, the id field will be used to
	 *                 update that account in the database
	 * @return
	 */
	public Account update(Account account) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update accounts set user_name ='" + account.getUserName() + "', password ='"
					+ account.getPassword() + "', is_manager ='"+ account.getIsManagerInt() +"' where id =" + account.getId());
			return readAccount(account.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an account in the database
	 * 
	 * @param id - id of the account
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from accounts where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
	