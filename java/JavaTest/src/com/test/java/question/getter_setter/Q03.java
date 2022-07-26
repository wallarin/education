package com.test.java.question.getter_setter;

import java.util.Calendar;

public class Q03 {
	
	public static void main(String[] args) {
		
		Bugles snack = new Bugles();

		snack.setWeight(300);
		snack.setCreationTime(2022, 3, 25);
		System.out.printf("가격 : %,d원\n", snack.getPrice());
		System.out.printf("유통 기한이 %,d일 남았습니다.\n", snack.getExpiration());
		
		snack.setWeight(500);
		snack.setCreationTime(2022, 3, 25);
		System.out.printf("가격 : %,d원\n", snack.getPrice());
		System.out.printf("유통 기한이 %,d일 남았습니다.\n", snack.getExpiration());
		
		snack.setWeight(850);
		snack.setCreationTime(2022, 3, 25);
		System.out.printf("가격 : %,d원\n", snack.getPrice());
		System.out.printf("유통 기한이 %,d일 남았습니다.\n", snack.getExpiration());

		snack.eat();
		
	}

}

class Bugles {
	   private int price;
	   private int weight;
	   private Calendar creationTime;
	   private int expiration;

	   public void setWeight(int weight) {
		   if (weight == 300 || weight == 500 || weight == 850) {
			   this.weight = weight;
		   }
	   }

	   public int getPrice() {
		   if(this.weight == 300) {
			   return 850;
		   } else if (this.weight == 500) {
			   return 1200;
		   } else {
			   return 1950;
		   }
	}
	   public void setCreationTime(int year, int month, int date) {
		   Calendar creationTime = Calendar.getInstance();
		   if (this.weight == 300) {
			   creationTime.set(year, month - 1, date + 6); //오늘부터 포함이 되어야 하므로 7일이라면 - 1이 되어야함
		   } else if (this.weight == 500) {
			   creationTime.set(year, month - 1, date + 9);
		   } else {
			   creationTime.set(year, month - 1, date + 14);
		   }
		   this.creationTime = creationTime;
	   }


	   public int getExpiration() {
		   Calendar today = Calendar.getInstance();
		   long todayTick = today.getTimeInMillis();
		   long toTick = this.creationTime.getTimeInMillis();
		   
		   //System.out.println((toTick - todayTick) / 1000.0 / 60 / 60 / 24);
		   
		   if (this.weight == 300) { //Math.ceil 은 무조건 반올림
			   return (int)Math.ceil((toTick - todayTick) / 1000.0 / 60 / 60 / 24);
		   } else if (this.weight == 500) {
			   return (int)Math.ceil((toTick - todayTick) / 1000.0 / 60 / 60 / 24);
		   } else {
			   return (int)Math.ceil((toTick - todayTick) / 1000.0 / 60 / 60 / 24);
		   }
	   }
	   
	   
	   public void eat() {
		   if(getExpiration() >= 0) {
			   System.out.println("과자를 맛있게 먹습니다.");
		   } else {
			   System.out.println("유통기한이 지나 먹을 수 없습니다.");
		   }
	   }

}

