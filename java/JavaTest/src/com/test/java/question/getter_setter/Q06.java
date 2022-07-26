package com.test.java.question.getter_setter;

import java.util.Calendar;

public class Q06 {

	public static void main(String[] args) {
		Refrigerator r = new Refrigerator();

		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration(2022, 4, 9);
		r.add(item1);// 냉장고에 넣기

		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration(2022, 4, 2);
		r.add(item2);// 냉장고에 넣기

		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration(2022, 4, 4);
		r.add(item3);// 냉장고에 넣기
		System.out.println();

		Item item4 = r.get("깍두기");// 냉장고에서 꺼내기
		System.out.printf("%s의 유통기한 : %s\n", item4.getName(), item4.getExpiration());

		System.out.printf("냉장고 안의 총 아이템 개수 : %d개\n", r.count());
		System.out.println();

		System.out.println("[냉장고 아이템 목록]");
		r.listItem();

	}
}


class Refrigerator {
	private int i = 0;
	private Item[] items = new Item[100];

	public void add(Item item) {
		if (i == 100) {
			System.out.println("더 이상 냉장고에 빈 자리가 없습니다.");
			return;
		}

		items[i] = new Item();
		items[i] = item;
		System.out.println("'" + item.getName() + "'를 냉장고에 넣었습니다.");
		i++;

	}

	public Item get(String name) {
		Item getItem;
		for (int j = 0; j < i; j++) {
			if (items[j].getName() == name) {
				getItem = items[j];
				for (int k = j; k < i; k++) {
					items[k] = items[k + 1];
				}
				i--;
				return getItem;
			}
		}
		return null;
	}

	public int count() {
		return i;
	}

	public void listItem() {
		for (int j = 0; j < i; j++) {
			System.out.println(items[j].getName() + "(" + items[j].getExpiration() + ")");
		}
	}
}


class Item {
	private String name;
	private Calendar expiration = Calendar.getInstance();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpiration() {
		String date = expiration.get(Calendar.YEAR) + "-" + expiration.get(Calendar.MONTH) + "-"
				+ expiration.get(Calendar.DATE);
		return date;
	}

	public void setExpiration(int year, int month, int date) {
		expiration.set(year, month, date);
	}


}


