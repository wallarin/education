package com.test.java.question.file_in_out;

import java.io.BufferedReader;
import java.io.FileReader;

public class Q07 {
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\출결.dat"));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] hi = line.split(",");
				
				String[] come = hi[2].split(":");
				String[] bye = hi[3].split(":");
				System.out.println(come.length);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
