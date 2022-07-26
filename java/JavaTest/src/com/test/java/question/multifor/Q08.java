package com.test.java.question.multifor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {
	
	 public static void main(String[] args) throws Exception {
		
		/*
		 
			요구사항] 숫자를 2개 입력받아 각각의 약수와 두 숫자의 공약수를 구하시오.

			조건..
			공약수: 둘 이상의 정수에 공통된 약수
			입력..
			첫번째 숫자: 12 
			
			두번째 숫자: 8 
			
			출력..
			12의 약수: 1, 2, 3, 4, 6, 12
			8의 약수: 1, 2, 4, 8
			12와 8의 공약수: 1, 2, 4
	
		*/
		 
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 
		 System.out.print("첫번째 숫자: ");
		 int num = Integer.parseInt(reader.readLine());
		 
		 System.out.print("두번째 숫자: ");
		 int num2 = Integer.parseInt(reader.readLine());
		 
		 String num_s1 = "";
		 String num_s2 = "";
		 String result = "";
		 
		 for(int i = 1; i<=num; i++){
	            if(num % i == 0){
	            	num_s1 += i + " ";
	             }   
	         }   
			
		 System.out.println();
		 
		 for(int i = 1; i<=num2; i++){
	            if(num2 % i == 0){
	            	num_s2 += i + " ";
	            }
			}
		 
		 //공약수를 구하는 식
		 if (num > num2) {
			 for(int i = 1; i<=num2; i++){
		            if(num % i == 0 && num2 % i == 0){
		            	result += i + " ";
		             }   
		         }   
			 
		 } else if (num < num2){
			 for(int i = 1; i<=num; i++){
		            if(num2 % i == 0 && num % i == 0){
		            	result += i + " ";
		             }   
		         }  
			 
		 } else {
			 for(int i = 1; i<=num; i++) {
				 if(num2 % i == 0 && num % i == 0){
	            	result += i + " ";
	            	}
			 }
		 }
		 System.out.printf("%d의 약수 [ %s]\n",num, num_s1);
		 System.out.printf("%d의 약수 [ %s]\n",num2, num_s2);
		 System.out.printf("%d과(와) %d의 공약수 [ %s]", num, num2, result);
	}

}
