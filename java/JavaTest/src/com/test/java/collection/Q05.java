package com.test.java.collection;

public class Q05 {
	
	public static void main(String[] args) {
		
		MySet set = new MySet();
		
		System.out.println(set);
		
		System.out.println(set.add("홍길동"));
		System.out.println(set.add("아무개"));
		System.out.println(set.add("홍길동"));
		System.out.println(set.add("하하하"));
		System.out.println(set.add("호호호"));
		System.out.println(set.add("후후후"));
		System.out.println(set.add("헤헤헤"));
		System.out.println(set.add("히히히"));
		
		System.out.println(set);
		
		System.out.println(set.remove("하하하"));
		
		System.out.println(set);
		
		System.out.println();
		
		while (set.hasNext()) {
			System.out.println(set.next());
		}
		
	}

}
