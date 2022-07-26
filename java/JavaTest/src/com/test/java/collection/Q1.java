package com.test.java.collection;

public class Q1 {
	
	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList();
		
		list.add("바나나");
		list.add("사과");
		list.add("포도");
		list.add("딸기");
		
		System.out.println(list);
		
		list.add("귤");
		
		System.out.println(list);
		
//		list.add("복숭아");
//		list.add("앵두");
//		list.add("배");
		
//		System.out.println(list);
		
		System.out.println(list.size());
		
//		list.set(7, "복숭아");
		
//		System.out.println(list);
		
//		list.remove(2);
		list.add(2, "참외");
		list.add(2, "앵두");
		list.add(2, "토마토");
		list.add(2, "토마토");
		System.out.println(list);
		
		//if 실제로 방이 존재하는 데 값이 없다면?? > null이 출력된다..
		
		//System.out.println(list.get(9)); 
		
//		list.add("체리");
//		
//		System.out.println(list);
		
		System.out.println(list.indexOf("딸기"));
		
		list.clear(); //모두 지웠다고 생각하지만 다시 0번째 방으로 들어감으로 눈속임이 가능
		
		System.out.println(list);
		
		list.trimToSize();
		
		System.out.println(list);
		
		
	}
}





















