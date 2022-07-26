package com.test.java.io;

import java.io.File;
import java.util.HashSet;

public class Q07 {
	
	public static void main(String[] args) {
		

		File dirA = new File("C:\\Users\\dnfkt\\Desktop\\파일_디렉토리_문제 (2)\\동일 파일\\MusicA");
		File dirB = new File("C:\\Users\\dnfkt\\Desktop\\파일_디렉토리_문제 (2)\\동일 파일\\MusicB");
		
		String[] listA = dirA.list();
		String[] listB = dirB.list();
		
		/* 이중 for문으로 같은지 하나씩 확인
		
		for(String s1 : listA) {
			for(String s2 : listB) {
				if(s1.equals(s2)) {
					System.out.println(s1);
					break;
				}
			}
		}
  
		*/
		
		//HashSet > 중복값
		//1. 수업 중에 배운걸로 풀기.
		//2. 안 배운 기능도 추가
		
		//Set > 집합 > 교집합, 합집합, 차집합..
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		
		set1.add("빨강");
		set1.add("노랑");
		set1.add("파랑");
		set1.add("주황");
		set1.add("검정");
		
		set2.add("빨강"); //v 중복
		set2.add("녹색");
		set2.add("분홍");
		set2.add("주황"); //v 중복
		set2.add("검정"); //v 중복
		
//		set1.addAll(set2); //중복값을 제외한 합집합..
//		System.out.println(set1);
		
//		set1.retainAll(set2); //교집합..
//		System.out.println(set1);
		
//		set1.removeAll(set2); //set2의 중복값을 뺀 나머지 > 차집합..
//		System.out.println(set1);
		
		HashSet<String> list1 = new HashSet<String>();
		HashSet<String> list2 = new HashSet<String>();
		
		for(String s : listA) {
			list1.add(s);
		}
		
		for(String s : listB) {
			list2.add(s);
		}
		
		list1.retainAll(list2);
		System.out.println(list1);
		
	}

}


























