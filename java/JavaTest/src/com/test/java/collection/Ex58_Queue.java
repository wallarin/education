package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Ex58_Queue {
	
	public static void main(String[] args) {
		
		//Queue
		//- 선입선출
		
		Queue<String> queue = new LinkedList<String>();
		
		//1. 요소 추가하기
		//- boolean add(T value)
		queue.add("빨강"); // 다른 언어들은 enque로 넣는다
		queue.add("파랑");
		queue.add("노랑");
		
		//2. 요소 개수
		//- int size()
		System.out.println(queue.size());
		
		//3. 요소 읽기(=꺼내기)
		System.out.println(queue.poll()); // 다른 언어들은 deque로 꺼낸다.
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll()); //stack 과 다르게 아무것도 없으면 Null을 반환한다.. > 에러 안남
		System.out.println(queue.size());
		
		//4. 비었는지?
		System.out.println(queue.size() == 0);
		System.out.println(queue.isEmpty());
		
		//5. 요소 확인하기
		queue.add("주황");
		
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
		//6. 전부 삭제
		queue.clear();
		System.out.println(queue.size());
		
		
		
	}

}





















