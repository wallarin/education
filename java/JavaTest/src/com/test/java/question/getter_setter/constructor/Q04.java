package com.test.java.question.getter_setter.constructor;

public class Q04 {

	public static void main(String[] args) {
		
		// 바리스타
		Barista barista = new Barista();

		// 손님 1
		// 에스프레소 1잔 주문 - 원두 30g
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();
		// 손님 2
		// 라테 1잔 주문 - 원두 30g, 우유 250ml
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();

		// 손님 3
		// 아메리카노 1잔 주문 - 원두 30g, 물 300ml, 각얼음 20개
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();
		System.out.println();

		// 손님 4
		// 에스프레소 10잔 주문 - 원두 25g
		Espresso[] e2 = barista.makeEspressoes(25, 10);

		for (Espresso e : e2) {
			e.drink();
		}
		System.out.println();
		// 손님 5
		// 라테 5잔 주문 - 원두 25g, 우유 300ml
		Latte[] l2 = barista.makeLattes(25, 300, 5);

		for (Latte l : l2) {
			l.drink();
		}
		System.out.println();

		// 손님 6
		// 아메리카노 15잔 주문 - 원두 20g, 물 350ml, 각얼음 30개
		Americano[] a2 = barista.makeAmericanos(20, 350, 30, 15);

		for (Americano a : a2) {
			a.drink();
		}
		System.out.println();

		// 결산
		barista.result();


	}


}


class Barista {
	Espresso makeEspresso(int bean) {
		Espresso espresso = new Espresso(bean);
		return espresso;
	}


	Espresso[] makeEspressoes(int bean, int count) {
		Espresso[] espresso = new Espresso[count];
		for (int i = 0; i < count; i++) {
			espresso[i] = new Espresso(bean);
		}
		return espresso;
	}

	Latte makeLatte(int bean, int milk) {
		Latte latte = new Latte(bean, milk);
		return latte;
	}

	Latte[] makeLattes(int bean, int milk, int count) {
		Latte[] latte = new Latte[count];
		for (int i = 0; i < count; i++) {
			latte[i] = new Latte(bean, milk);
		}
		return latte;
	}

	Americano makeAmericano(int bean, int water, int ice) {
		Americano americano = new Americano(bean, water, ice);
		return americano;
	}

	Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		Americano[] americano = new Americano[count];
		for (int i = 0; i < count; i++) {
			americano[i] = new Americano(bean, water, ice);
		}
		return americano;
	}

	public void result() {
		System.out.println("---------------------------------");
		System.out.println("음료 판매량");
		System.out.println("---------------------------------");
		System.out.printf("에스프레소 : %,d잔\n", Coffee.espresso);
		System.out.printf("아메리카노 : %,d잔\n", Coffee.americano);
		System.out.printf("라테 : %,d잔\n", Coffee.latte);
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

	}
}


class Coffee {
	public static int bean;
	public static int water;
	public static int ice;
	public static int milk;
	public static int beanUnitPrice = 1;
	public static double waterUnitPrice = 0.2;
	public static int iceUnitPrice = 3;
	public static int milkUnitPrice = 4;
	public static int beanTotalPrice;
	public static int waterTotalPrice;
	public static int iceTotalPrice;
	public static int milkTotalPrice;
	public static int americano;
	public static int latte;
	public static int espresso;
}


class Espresso {
	private int bean;

	public Espresso(int bean) {
		Coffee.bean += bean;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.espresso++;
		this.bean = bean;
	}

	public int getBean() {
		return bean;
	}

	public void setBean(int bean) {
		
		this.bean = bean;
	}

	void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", this.bean);
	}
}


class Latte {
	private int bean;
	private int milk;

	public Latte(int bean, int milk) {
		Coffee.bean += bean;
		Coffee.milk += milk;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.milkTotalPrice += milk * Coffee.milkUnitPrice;
		Coffee.latte++;
		this.bean = bean;
		this.milk = milk;
	}

	public int getBean() {
		return bean;
	}

	public void setBean(int bean) {
		this.bean = bean;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	void drink() {
		System.out.printf("원두 %dg, 우유 %dml으로 만들어진 라테를 마십니다.\n", this.bean, this.milk);
	}
}


class Americano {
	private int bean;
	private int water;
	private int ice;

	public Americano(int bean, int water,  int ice) {
		Coffee.bean += bean;
		Coffee.water += water;
		Coffee.ice += ice;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.waterTotalPrice += water * Coffee.waterUnitPrice;
		Coffee.iceTotalPrice += ice * Coffee.iceUnitPrice;
		Coffee.americano++;
		this.bean = bean;
		this.water = water;
		this.ice = ice;
	}

	void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\n", this.bean, this.water, this.ice);
	}
}


