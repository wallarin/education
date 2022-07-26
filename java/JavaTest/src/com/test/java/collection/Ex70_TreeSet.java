package com.test.java.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ex70_TreeSet {
	
	public static void main(String[] args) {
		
		/*
		
			Set
			- 순서가 없다.
			- 중복값을 가지지 않는다.
			
			HashSet
			
			TreeSet
			- 이진 트리 구조 > 가질 수 있는 자식이 0~2명
		
		*/
		
		m1();
		
	}

	private static void m1() {

		Set<Integer> set1 = new HashSet<Integer>();
		
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(40);
		set1.add(50);
		
		set2.add(10);
		set2.add(20);
		set2.add(30);
		set2.add(40);
		set2.add(50);
		
		
		//탐색
		Iterator<Integer> iter1 = set1.iterator();

		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		System.out.println();
		
		Iterator<Integer> iter2 = set2.iterator();
		
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		System.out.println();
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println();
		
		TreeSet<Integer> set3 = new TreeSet<Integer>();
		Random rnd = new Random();
		
		//for (; set3.size() < 10; ) {
		while (set3.size() < 20) {
			set3.add(rnd.nextInt(100));
		}
		
		System.out.println();
		System.out.println(set3);
		System.out.println(set3.size());
		System.out.println();
		
		//TreeSet 고유 메소드
		System.out.println(set3.first());
		System.out.println(set3.last());
		
		//자바의 모든 인덱스 범위
		//- 시작위치(포함) ~ 끝위치(미포함)
		System.out.println(set3.headSet(30)); //설정 값 미포함
		System.out.println(set3.tailSet(70)); //설정 값 포함
		System.out.println(set3.subSet(30, 70)); //설정 앞 값 미포함, 뒷 값 포함
		
	}

}
























