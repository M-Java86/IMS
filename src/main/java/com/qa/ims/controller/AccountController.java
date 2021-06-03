package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.AccountDAO;




public abstract class AccountController<Account> implements CrudController<Account> {
	
	
		public static final Logger Logger = LogManager.getLogger();
		
		private AccountDAO accountDAO;
		private utils utils;
	

}

