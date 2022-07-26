package com.test.java.collection;

import java.util.Map;
import java.util.TreeMap;

public class Ex71_TreeMap {
	
	public static void main(String[] args) {
		
		//Tree + Map
		//- 이진 트리 구조의 Map
		//- 자동 정렬 + 범위 검색(추출) 용이
		
		Map<String,String> map = new TreeMap<String,String>();
		
		map.put("white", "하양");
		map.put("black", "검정");
		map.put("yellow", "노랑");
		map.put("red", "빨강");
		map.put("blue", "파랑");
		
		System.out.println(map.size());
		
		System.out.println(map);
		
		System.out.println(((TreeMap<String, String>) map).firstKey());
		System.out.println(((TreeMap<String, String>) map).firstEntry());
		System.out.println(((TreeMap<String, String>) map).lastKey());
		
		System.out.println(((TreeMap<String, String>) map).headMap("m"));
		System.out.println(((TreeMap<String, String>) map).tailMap("m"));
		System.out.println(((TreeMap<String, String>) map).subMap("r", "w"));
		
		/*
		
			*** 길이 가변
			
			처음 선택(1,5,7) > 상황에 맞춰(2,3,4,6,8)
		
			List
			1. ArrayList > 배열이 필요할 때, 삽입/삭제 (X)
			2. LinkedList > ArrayList 대체제 + 삽입/삭제(O)
			3. Stack > 스택 구조
			4. Queue > 큐 구조
			
			Set
			5. HashSet > 중복값 배제 집합이 필요할 때
			6. TreeSet > + 정렬이 필요할 때
			
			Map
			7. HashMap > 키/값의 배열이 필요할 때
			8. TreeMap > + 정렬이 필요할 때
		
		*/
		
	}//main

}//Ex71
