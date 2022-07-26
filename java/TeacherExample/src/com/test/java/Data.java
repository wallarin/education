package com.test.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {
	
	public static ArrayList<User> list;
	
	static {
		Data.list = new ArrayList<User>();
	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\user.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				User u = new User(temp[0], temp[1], temp[2], temp[3], temp[4]);
				Data.list.add(u);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
	}
	
	public static void save() {
		
	}

}
