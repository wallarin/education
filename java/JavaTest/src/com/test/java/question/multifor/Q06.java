package com.test.java.question.multifor;

public class Q06 {
	
	 public static void main(String[] args) {
		
		 /*
		 
		 	요구사항] 2부터 100사이의 소수를 구하시오.

			조건..
			소수: 1과 자기자신으로밖에 나눠지지 않는 수
			출력..
			2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
		 
		 
		 */
		 int count = 0;
		 
		 for (int i=2; i<=100; i++) {
			 
			 for (int j=2; j<=i; j++) {
				 if(i % j == 0) {
					 count++; //소수로 나누어지면 1을 증가시킨다
				 }
			 }
			 if(i<97) {
				 if(count==1) { //증가시켰던 count 변수가 1이라면 값을 출력하고 count를 0으로 만든다.
					 System.out.print(i + ", ");
				 } count = 0;
			 } else if (i>=97) {
				 if(count==1) {
					 System.out.print(i);
				 } count = 0;
					 
					 
			 }
			 
			 
		 }
		 //System.out.println("\b\b");

	}

}
