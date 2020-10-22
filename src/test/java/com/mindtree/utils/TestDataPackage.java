package com.mindtree.utils;

import java.util.Random;

public class TestDataPackage {
	
	public static String custBody() {

		Random random = new Random();
		int randomInt = random.nextInt(10000);
		return Integer.toString(randomInt);
		
	}
	
	public static String employee() {
		
		return "{\r\n" + 
				"	\"name\":\"Ragaven\",\r\n" + 
				"	\"salary\":\"23211\",\r\n" + 
				"	\"age\":\"22\"\r\n" + 
				"}";
		
	}
	
	public static String jiraAuth(String username, String password) {
		return "{\r\n" + 
				"		\"username\":\""+username+"\",\r\n" + 
				"		\"password\":\""+password+"\"\r\n" + 
				"	}";
		
	}
	
	

}