package com.test.java.collection;

import java.util.ArrayList;

public class Ex56_ArrayList {
	
	public static void main(String[] args) {
		
		//Ex56_ArrayList.java
		
		/*
		
			컬렉션, Collection
			- JCF, Java Collection Framework
			- (향상된) 배열
			- 기존의 순수 배열의 성능 향상(입출력), 사용법을 개량 > 클래스
			- 내부에 순수 배열을 가지고 있다. > public 메소드들을 통해서 성능 or 사용법 개량
			- 길이 가변 > 방의 개수를 마음대로 늘리고 줄이는게 가능
			- 자료 구조
			
			
			컬렉션 종류
			1. List 계열
				- ArrayList
				- LinkedList
				- Queue
				- Stack
				- Vector(legacy)
			
			2. Set 계열
				- HashSet
				- TreeSet
			
			3. Map 계열
				- HashMap
				- HashTable(legacy)
				- TreeMap
				- Properties(legacy)
			
			
			
			
			
			
			ArrayList 클래스
			- ArrayList(C) -> List(I) -> Collection(I)
			- 순수 배열하고 구조가 가장 유사함
			- 사용 빈도가 가장 높음 > 가장 많이 복습!!!
			- 첨자(index)를 사용해서 요소(element)에 접근
		
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();
		
	}//main

	private static void m7() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//*** 컬렉션에 반복적으로 데이터를 넣는 행동 > 가변 특성 유지
		//1. 가비지 발생 > 비용 발생
		//2. 배열 복사 발생 > 비용 발생
		
		//위의 문제점을 해결 방법
		//- ArrayList의 초기 길이를 지정할 수 있다.
		//ArrayList<Integer> list = new ArrayList<Integer>(10);
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		list.add(10); //20칸이 된다..
		
		//*** 이 이후로.. list에 데이터를 추가할 일이 없다.. > 9칸이 남는다..
		
		//확신이 들때만 가끔 호출..
		list.trimToSize(); //20칸 -> 11칸으로 줄인다..
		
		System.out.println(list.size());
		
		int[] num = new int[10];
		
		for(int i=0; i<10; i++) {
			num[i] = i;
		}
		
		for (int n : list) {
			System.out.println(n);
		}
		
		System.out.println();
		
		for (int n : num) {
			System.out.println(n);
		}
		
		
		//ArrayList -> 데이터 -> 1025개 추가
		
	}

	private static void m6() {
		
		//AraayList(컬렉션) 특징
		//1. 내부에 배열을 가지고 있다. == ArrayList를 배열이라고 생각하자.
		//2. ArrayList 클래스의 대부분 기능이 내부 배열을 조작하는 기능들로 구성
		//3. 길이가 가변 > 데이터를 넣으면.. 계속 공간이 늘어난다.
		
		//1 + 3=?
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		
		System.out.println(list.size()); //내부 배열의 길이 4, size는 1
		//size는 실제 들어가 있는 데이터의 개수를 세어준다..
		
		list.add(20);
		list.add(30);
		list.add(40);
		
		System.out.println(list.get(1));
		
		list.add(50);
		
		//배열이 계속 늘어나는 이유?? > 배열이 가득 차면 2배의 배열을 새로 만들어 값을 복사하고 변수의 주소값을 새로 만든 배열로 복사한다.
		
		
	}

	private static void m5() {
		
		//선택?
		//- 배열(고정) vs ArrayList(불확실) > 길이가 고정이면 배열 사용 // 길이가 불확실 하면 ArrayList 사용
		//- 길이로 선택!!!
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		for (int i = 0; i < 10; i++) {
			
			int kor = (int)(Math.random() * 41) + 60;
			int eng = (int)(Math.random() * 41) + 60;
			int math = (int)(Math.random() * 41) + 60;
			
			Student s = new Student("학생" + (i+1), kor, eng, math);
			
			list.add(s); //배열에 학생 추가
			
		}
		
		System.out.println(list.get(0));
		
		
		//성적표 출력
		System.out.println("=============================================");
		System.out.println("		   성적표");
		System.out.println("=============================================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		for (Student s : list) {
			
			int total = s.getKor() + s.getEng() + s.getMath();
			double avg = total / 3.0;
			
			System.out.printf("%s\t%4d\t%4d\t%4d\t%4d\t%4.1f\n"
								, s.getName()
								, s.getKor()
								, s.getEng()
								, s.getMath()
								, total
								, avg);
		}
		
	}

	private static void m4() {
		
		//배열(컬렉션)의 요소
		//- 값형 데이터, 문자열
		//- 객체
		
		//1. Cup을 5개 만들어라!!
		//2. Cup을 담을 수 있는 방을 5개 만들어라!!
		//Cup[] clist = new Cup[5]; //Cup을 담을 방을 만들었다. //***** 2번

		//System.out.println(clist[0].toString()); //NullPointerException
		
		//1. Cup을 5개 만들어라!! > 인스턴스(객체)를 5개 만들어라
		Cup c1 = new Cup("", 0);
		Cup c2 = new Cup("", 0);
		Cup c3 = new Cup("", 0);
		Cup c4 = new Cup("", 0);
		Cup c5 = new Cup("", 0);
		
		//2. Cup을 담을 수 있는 방을 5개 만들어라!! > 인스턴스 X
		Cup p1;
		Cup p2;
		Cup p3;
		Cup p4;
		Cup p5;
		
		Cup[] clist = new Cup[5];
		
		clist[0] = new Cup("", 1_000); //1번째 컵 객체
		clist[1] = new Cup("", 0); //2번째 컵 객체
		clist[2] = new Cup("", 0); //3번째 컵 객체
		clist[3] = new Cup("", 0); //4번째 컵 객체
		clist[4] = new Cup("", 5_000); //5번째 컵 객체
		
		
		ArrayList<Cup> list = new ArrayList<Cup>();
		list.add(new Cup("", 6_000)); //1번째 컵
		list.add(new Cup("", 0)); //2번째 컵
		list.add(new Cup("", 0)); //3번째 컵
		list.add(new Cup("", 0)); //4번째 컵
		list.add(new Cup("", 10_000)); //5번째 컵
		
		for (int i = 0; i <clist.length; i++) {
			System.out.println(clist[i]);
		}
		System.out.println();
		System.out.println();
		
		for (Cup cup : clist) {
			System.out.println(cup);
		}
		System.out.println();
		System.out.println();
		
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		System.out.println();
		
		for (Cup cup : list) {
			System.out.println(cup);
		}
		
		
	}

	private static void m3() {
		
		int[] 	  ns1 = new int[3];
		int[][]   ns2 = new int[2][3];
		int[][][] ns3 = new int[2][3][3];
		
		//ns1
		ArrayList<Integer> ms1 = new ArrayList<Integer>();
		
		//ns2 > 2차원 정수 배열
		ArrayList<ArrayList<Integer>> ms2 = new ArrayList<ArrayList<Integer>>();
		
		//ns3 > 3차원 정수 배열
		ArrayList<ArrayList<ArrayList<Integer>>> ms3
			= new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		//2차원 배열 초기화
		ns2[0][0] = 10; //*****
		
		//2차원 컬렉션의 초기화
		ArrayList<Integer> list = new ArrayList<Integer>(); //******
		list.add(10); 										//******
		ms2.add(list); 										//******
		//ms2.add(20, list);
		
		System.out.println(ms2.get(0));
		
	}

	private static void m2() {
		
		//ArrayList 사용법
		ArrayList<String> list = new ArrayList<String>(); //문자열 배열
		
		//1. 요소 추가하기
		//- boolean add(T value)
		//- 배열의 맨 마지막에 추가하기 > Append Mode
		list.add("바나나");
		list.add("딸기");
		list.add("포도");
		list.add("귤");
		list.add("사과");
		list.add("파인애플");
		
		//2. 요소의 개수
		//- int size()
		System.out.println(list.size());
		System.out.println();
		
		//3. 요소의 접근
		//- T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(4));
		System.out.println();
		//System.out.println(list.get(5)); //IndexOutOfBoundsException
		
		System.out.println(list.get(list.size() - 1)); //마지막 요소
		
		//4. 요소의 수정
		//- list[0] = 10; 대입, 수정
		//- String set(int index, T newValue)
		String temp = list.set(2, "파인애플");
		System.out.println(temp);
		System.out.println(list.get(2));
		System.out.println();
		
		//5. 요소의 삭제
		//- 순수 배열은 요소 삭제 불가능
		//- 컬렉션은 요소 삭제 가능
		//- T remove(int index) > 방번호를 찾아서 삭제
		//- boolean remove(T value) > 값을 찾아서 삭제 > 처음 만나는 요소만 삭제
		//- ***** 시프트가 발생한다!!!!!! > 삭제된 방 이후의 모든 요소는 모두 방번호 -1 감소
		
		System.out.println(list.get(3)); //귤
		System.out.println();
		
		
		list.remove(2);
		System.out.println(list.get(3)); //귤 -> 사과
		//list.remove("파인애플");
		//list.remove("파인애플");
		
		
		//6. 탐색
		//- 루프
		for (int i=0; i < list.size(); i++) {
			System.out.printf("list[%d] = %s\n", i, list.get(i));
		}
		System.out.println();
		
		//반복문 > for, while, do while, 향상된 for
		
//		for (변수 : 배열(컬렉션)) {
//			
//		}
		
		for (String item : list) { //무조건 처음부터 순서대로 끝까지 다 회전한다.
			System.out.println(item);
		}
		System.out.println();
		
		
		//7.요소의 추가
		//- 배열의 원하는 위치에 요소를 추가 > Insert Mode
		//- 삽입(새치기)
		//- void add(int index, T value)
		//- ****** 시프트가 발생한다. > 삽입된 방 이후의 모든 요소가 방번호 +1
		list.add(2, "망고");
		
		for (String item : list) { //무조건 처음부터 순서대로 끝까지 다 회전한다.
			System.out.println(item);
		}
		System.out.println();
		
		//8. 요소의 검색
		//- int indexOf(T value)
		//- boolean contains(T value)
		//- 배열안에 원하는 요소가 있는지 검색
		
		System.out.println(list.indexOf("파인애플"));
		System.out.println(list.contains("파인애플"));
		System.out.println();
		
		//9. 초기화
		//- 모든 요소 삭제 > 모든방.remove()
		//- void clear()
		list.clear();
		
		System.out.println(list.size());
		
		
		//10. 빈배열 확인?
		//- boolean isEmpty()
		System.out.println(list.size() == 0);
		System.out.println(list.isEmpty());
		
		
		
	}

	private static void m1() {
		
		//ArrayList list1 = new ArrayList();
		
		
		//순수 배열
		//- 타입 명시(int)
		//- 길이 명시(3)
		int[] num1 = new int[3];
		
		//요소 접근 > 첨자(index) 사용
		num1[0] = 10;
		num1[1] = 20;
		num1[2] = 30;
		
		System.out.println(num1[0]); //식별자[첨자] -> 인덱서(Indexer) > 자바는 배열만 인덱서 사용 가능
		System.out.println(num1[1]);
		System.out.println(num1[2]);
		
		System.out.println(num1.length);
		System.out.println();
		
		//컬렉션
		//- 타입 명시(Integer) > 제네릭
		//- 길이 명시 > ??? > 가변
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		//요소 접근 > 첨자? > Append > 차례대로 마지막 방에 넣어라!!!
		list1.add(10); //0번째 방 추가
		list1.add(20); //1번째 방 추가
		list1.add(30); //2번째 방 추가
		
		System.out.println(list1.get(0)); //list1[0] 다른곳들은 < 이렇게 사용
		System.out.println(list1.get(1));
		System.out.println(list1.get(2));
		
		System.out.println(list1.size());
		
		list1.add(40);
		list1.add(50);
		System.out.println(list1.size());
		System.out.println();
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		System.out.println();
		System.out.println();
		
//		for(Integer item : list1) { //향상된 for문
//			System.out.println(item);
//		}
		
	}

}//Ex56



class Cup {
	
	private String color;
	private int price;
	
	public Cup(String color, int price) {
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cup [color=" + color + ", price=" + price + "]";
	}
	
}



class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}
	
	
	
}


//Member m = new Member();

class Member {
	
	private int a;
	private String b;
	private int[] c;
	
	public Member() {
		a =10;
		b="홍길동";
		c= new int[5];
	}
}

























