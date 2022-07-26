package com.test.java.question.multifor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		
			요구사항] 아래와 같이 출력하시오.

			조건..
			행의 갯수를 입력받으시오.
			입력..
			행: 5 
			
			출력..
			    aa
			   abba
			  abccba
			 abcddbca
			abcdeedcba
			입력..
			행: 7 
			
			출력..
			      aa
			     abba
			    abccba
			   abcddbca
			  abcdeedcba
			 abcdeffedcba
			abcdefggfedcba
					
		*/
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행: ");
		int star = Integer.parseInt(reader.readLine());
		char alpha = 97;
		
			for (int i=0; i<star; i++) {
			
			for (int j=2; j<=(star-i); j++) {
				System.out.print(" ");
			}
			
			for (int j=0; j<=i; j++) {
				System.out.printf("%c",alpha);
				alpha++;
			}
			
			for (int k=0; k<=i; k++) {
				System.out.printf("%c",alpha-1);
				alpha--;
			}
			
			
			System.out.println();
		}
		
	}

}
