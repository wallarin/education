package com.test.java.question.multifor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
		
		/*
		요구사항] 아래와 같이 출력하시오.

		조건..
		행의 갯수를 입력받으시오.
		입력..
		행: 5 

		출력..
		    *
		   **
		  ***
		 ****
		*****
		입력..
		행: 7 

		출력..
		      *
		     **
		    ***
		   ****
		  *****
		 ******
		*******
		
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		int star = Integer.parseInt(reader.readLine());
		
		
			for (int i=0; i<star; i++) {
			
			for (int j=1; j<(star-i); j++) {
				System.out.print(" ");
			}
			
			for (int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
