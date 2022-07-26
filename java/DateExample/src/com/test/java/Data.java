package com.test.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Data {
	
	public static ArrayList<Item> list;
	
	static {
		Data.list = new ArrayList<Item>();
	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\data.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Item item = new Item(temp[0], temp[1], temp[2]);
				Data.list.add(item);
				
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
