package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) {
		//바리스타
		Barista barista = new Barista();

		//손님 1
		//에스프레소 1잔 주문 - 원두 30g
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();
		//원두 30g으로 만들어진 에스프레소를 마십니다. //e1.drink();

		//손님 2
		//라테 1잔 주문 - 원두 30g, 우유 250ml
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();
		//원두 30g, 우유 250ml으로 만들어진 라테를 마십니다. //l1.drink();

		//손님 3
		//아메리카노 1잔 주문 - 원두 30g, 물 300ml, 각얼음 20개
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();
		//원두 30g, 물 300ml, 얼음 20개로 만들어진 아메리카노를 마십니다. //a1.drink();
		
		//손님 4
		System.out.println();
		System.out.println("손님4");
		//에스프레소 10잔 주문 - 원두 25g
		Espresso[] e2 = barista.makeEspressoes(25, 10);

		for (Espresso e : e2) {
		      e.drink();
		}

		//손님 5
		System.out.println();
		System.out.println("손님5");
		//라테 5잔 주문 - 원두 25g, 우유 300ml
		Latte[] l2 = barista.makeLattes(25, 300, 5);

		for (Latte l : l2) {
		      l.drink();
		}
	
		
		//손님 6
		System.out.println();
		System.out.println("손님6");
		//아메리카노 15잔 주문 - 원두 20g, 물 350ml, 각얼음 30개
		Americano[] a2 = barista.makeAmericanos(20, 350, 30, 15);

		for (Americano a : a2) {
		      a.drink();
		}

		System.out.println();
		
		//결산
		barista.result();
	}

}
class Barista {

	Espresso makeEspresso(int bean) {
		//에스프레소 1잔을 만든다.
		//int bean : 원두량(g)
		Espresso e1 = new Espresso(bean);

		return e1;
	}//Espresso
	
	Espresso[] makeEspressoes(int bean, int count) {
		//에스프레소 N잔을 만든다.
		//int bean : 원두량(g)
		//int count : 음료 개수(잔)
		Espresso[] e2 = new Espresso[count];
		for(int i=0; i<e2.length; i++) {
			e2[i] = new Espresso(bean);
		}
		return e2;
	}//Espresso
	
	Latte makeLatte(int bean, int milk) {
		//라테 1잔을 만든다.
		//int baen : 원두량(g)
		//int milk : 우유량(ml)
		Latte l1 = new Latte(bean, milk);
		//Latte : 라테 1잔
		return l1;
	}//Latte
	
	Latte[] makeLattes(int bean, int milk, int count) {
		//라테 N잔을 만든다.
		//int baen : 원두량(g)
		//int milk : 우유량(ml)
		//int count : 음료 개수(잔)
		Latte[] l2 = new Latte[count];
		for(int i=0; i<l2.length; i++) {
			l2[i] = new Latte(bean, milk);
		}
		//라테 N잔 return
		return l2;
	}//Latte
	
	
	Americano makeAmericano(int bean, int water, int ice) {
		//아메리카노 1잔을 만든다.
		//int baen : 원두량(g)
		//int water : 물량(ml)
		//int ice : 얼음 개수(개)
		Americano a1 = new Americano(bean, water, ice);
		//아메리카노 1잔
		return a1;
	}//Americano
	
	Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		//아메리카노 N잔을 만든다.
		//int baen : 원두량(g)
		//int water : 물량(ml)
		//int ice : 얼음 개수(개)
		//int count : 음료 개수(잔)
		Americano[] a2 = new Americano[count];
		for(int i=0; i<a2.length; i++) {
			a2[i] = new Americano(bean, water, ice);
		}
		//아메리카노 N잔
		return  a2;
	}//Americano[]
	
	void result() {
		//판매 결과를 출력한다.
		//음료 판매량(에스프레소 판매 개수, 라테 판매 개수, 아메리카노 판매 개수)
		//원자재 소비량(원두 소비량, 물 소비량, 우유 소비량, 얼음 소비량)
		//매출액(원두 판매액, 물 판매액, 우유 판매액, 얼음 판매액)
		System.out.println("=================================");
		System.out.println("판매 결과");
		System.out.println("=================================");
		System.out.println();
		
		System.out.println("---------------------------------");
		System.out.println("음료 판매량");
		System.out.println("---------------------------------");
		System.out.printf("에스프레소 : %d잔\n", Coffee.espresso);
		System.out.printf("아메리카노 : %d잔\n", Coffee.americano);
		System.out.printf("라테 : %d잔\n", Coffee.latte);
		System.out.println();
		
		System.out.println("---------------------------------");
		System.out.println("원자재 소비량");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,dg\n", Coffee.bean);
		System.out.printf("물 : %,dml\n", Coffee.water);
		System.out.printf("얼음 : %,d개\n", Coffee.ice);
		System.out.printf("우유 : %,dml\n", Coffee.milk);
		System.out.println();
		
		System.out.println("---------------------------------");
		System.out.println("매출액");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,d원\n", Coffee.beanTotalPrice);
		System.out.printf("물 : %,d원\n", Coffee.waterTotalPrice);
		System.out.printf("얼음 : %,d원\n", Coffee.iceTotalPrice);
		System.out.printf("우유 : %,d원\n", Coffee.milkTotalPrice);

	}//result
}//Barista

class Coffee {
	static int bean;						//총 원두량(g)
	static int water;						//총 물 용량(ml)
	static int ice;							//총 얼음 개수(개)
	static int milk;						//총 우유 용량(ml)
	static int beanUnitPrice 		= 1;	//원두 단가(원)		//1g당 1원
	static double waterUnitPrice 	= 0.2;	//물 단가(원)			//1ml당 0.2원
	static int iceUnitPrice 		= 3;;	//얼음 단가(원)		//1개당 3원
	static int milkUnitPrice 		= 4;	//우유 단가(원)		//1ml당 4원
	static int beanTotalPrice;				//원두 총 판매액(원)
	static int waterTotalPrice;				//물 총 판매액(원)
	static int iceTotalPrice;				//얼음 총 판매액(원)
	static int milkTotalPrice;				//우유 총 판매액(원)
	static int americano;					//아메리카노 총 판매 개수(잔)
	static int latte;						//라테 총 판매 개수(잔)
	static int espresso;					//에스프레소 총 판매 개수(잔)
}//Coffee

class Espresso {
	private int bean;					//에스프레소 생산 시 들어가는 원두량(g)
	
	public Espresso(int bean) {
		if(bean>0) this.bean = bean;
		else return;	
		updateInfo();
	}//Espresso

	public int getBean() {
		return bean;
	}//getBean
	
	private void updateInfo() {
		Coffee.bean += bean;
		Coffee.beanTotalPrice += this.bean*Coffee.beanUnitPrice;
		Coffee.espresso++;
	}//updateInfo
	
	void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", this.bean);
	}//drink
	
}//Espresso


class Latte {
	private int bean;					//라테 생산 시 들어가는 원두량(g)
	private int milk;					//라테 생산 시 들어가는 우유량(ml)
	
	public Latte(int bean, int milk) {
		if(bean>0 && milk>0) {
			this.bean = bean;
			this.milk = milk;
		}
		else return;	
		updateInfo();
	}//Latte
	
	public int getBean() {
		return bean;
	}//getBean
	
	public int getMilk() {
		return bean;
	}//getMilk
	
	private void updateInfo() {
		Coffee.bean += this.bean;
		Coffee.milk += this.milk;
		Coffee.beanTotalPrice += this.bean*Coffee.beanUnitPrice;
		Coffee.milkTotalPrice += this.milk*Coffee.milkUnitPrice;
		Coffee.latte++;
	}//updateInfo
	
	
	void drink() {
		System.out.printf("원두 %dg, 우유%dml으로 만들어진 라테 마십니다.\n", this.bean, this.milk);
	}//drink
	
}//Latte

class Americano {
	private int bean;					//아메리카노 생산 시 들어가는 원두량(g)
	private int water;					//아메리카노 생산 시 들어가는 물량(ml)
	private int ice;					//아메리카노 생산 시 들어가는 얼음 개수(개)
	
	public Americano(int bean, int water, int ice) {
		if(bean>0 && water>0) {
			this.bean = bean;
			this.water = water;
			this.ice = ice;
		}
		else return;	
		updateInfo();
	}//Latte
	
	public int getBean() {
		return bean;
	}//getBean
	
	public int getWater() {
		return water;
	}//getWater
	
	public int getIce() {
		return ice;
	}//getIce
	
	private void updateInfo() {
		Coffee.bean += this.bean;
		Coffee.water += this.water;
		Coffee.ice += this.ice;
		Coffee.beanTotalPrice += this.bean*Coffee.beanUnitPrice;
		Coffee.waterTotalPrice += this.water*Coffee.waterUnitPrice;
		if(this.ice>0) Coffee.iceTotalPrice += this.ice*Coffee.iceUnitPrice;
		Coffee.americano++;	
	}

	void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\n"
							, this.bean, this.water, this.ice);
	}//drink
	
}//Americano