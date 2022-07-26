package com.test.java.question.file_in_out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class Q06 {
	
	public static void main(String[] args) {
		
		try {
			//BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\괄호.java"));
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\java\\Hello.java"));
			Stack<Character> stack = new Stack<Character>();
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				for (int i = 0; i<line.length(); i++) {
					char c = line.charAt(i);
					
					if(c == '{' || c == '(') {
						stack.push(c);
					} 
					if (c == '}' || c == ')') {
						if (stack.peek() == '{' || stack.peek() == '(') {
							stack.pop();
						}
					}
				}
					
			}
			reader.close();
			
			if (stack.isEmpty()) {
				System.out.println("올바른 소스코드입니다.");
			} else {
				System.out.println("올바르지 않은 소스코드입니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
