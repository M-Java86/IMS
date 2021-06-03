package com.qa.ims.utils;


//import java.text.NumberFormat;
import java.util.Scanner;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Utils {
	
	private static final Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;
	private String errorMSG = "Error- Please enter a number";

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		String input = null;
		Long longInput = null;
		do {
			try {
				input = getString();
				longInput = Long.parseLong(input); //Conversion using parseLong(String) method
			} catch (NumberFormatException nfe) {
				LOGGER.info(errorMSG);
			}
		} while (longInput == null);
		return longInput;
	}

	public String getString() {
		return scanner.nextLine();//Returning String  from the current position to the end of the line. 
	}

	public Double getDouble() {
		String input = getString();
		Double doubleInput = null;
		do {
			try {
				
				doubleInput = Double.parseDouble(input);//returns a new double initialized to the value represented
				//by a specific String
			} catch (NumberFormatException nfe) { 
				LOGGER.info(errorMSG);
			}
		} while (doubleInput == null);
		return doubleInput;
	}

	public int getInt() {
		String input = getString();
		Integer  intInput = null;
		do {
			try {
					intInput = Integer.parseInt(input);//converting first argument into a string, then return as a Integer
			}	catch (NumberFormatException nfe) {
					   LOGGER.info(errorMSG);
					 
			}
			
		} while (intInput == null);
		  return intInput;
		  
	}
	
	public Boolean getBoolean() {
		String input = getString();
		Boolean boolInput = null; 
				/// convert string into Boolean 
		do {
			
			try {
					boolInput = Boolean.parseBoolean(input); ///Creating string into it's boolean value 
			}  catch (NumberFormatException nfe ) {
					 LOGGER.info("Error-Please enter TRUE OR FALSE");
			}
		} while (boolInput == null);
		  return boolInput;
	}
	
}
			
		
	

