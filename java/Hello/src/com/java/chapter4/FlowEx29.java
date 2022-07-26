package com.java.chapter4;

public class FlowEx29 {
	public static void main(String[] args) {
		for(int i=1; i<=1000; i++) {
			System.out.printf("i=%d", i);
			
			int tmp = i;
			//XXX 369게임!!
			do {
				if (tmp %10 %3 == 0 && tmp%10!=0) 
					System.out.print("짝");
			} while((tmp/=10)!=0);
			
			System.out.println();
		}
	}

}
