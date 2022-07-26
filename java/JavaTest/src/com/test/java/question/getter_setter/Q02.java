package com.test.java.question.getter_setter;

public class Q02 {
	
	public static void main(String[] args) {
		
		Note note = new Note();

		note.setSize("B4");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");

		System.out.println(note.info());


		Note note2 = new Note();

		note2.setSize("A4");
		note2.setColor("검정색");
		note2.setPage(100);

		System.out.println(note2.info());
		
	}

}

class Note  {
	   private String size;
	   private String color;
	   private int page;
	   private String owner;
	   private int price;
	   

		public void setSize(String size) {
			if (size == "A3" || size == "A4" || size == "A5" || size == "B3" || size == "B4"
					|| size == "B5") {
				this.size = size;
			}
		}
		
		public void setColor(String color) {
			if (color == "검정색" || color == "흰색" || color == "노란색" || color == "파란색") {
				this.color = color;
			}
		}

		public void setPage(int page) {
			if (page >= 10 && page <= 200) {
				this.page = page;
			}
		}

		public void setOwner(String owner) {
			if (checkOwner(owner)) {
				this.owner = owner;
			} else {
				System.out.println("올바르지 않은 소유자 입니다.");
			}
			
		}

		private boolean checkOwner(String owner) {
			for (int i = 0; i < owner.length(); i++) { 
			char c = owner.charAt(i);
			if (c < '가' || c > '힣') {
				return false;
				}
			}
			return true;
		}


		public String info() {
			
			if (owner == null) {
				System.out.println("■ ■ ■ ■ ■ ■ 노트 정보 ■ ■ ■ ■ ■ ■");
				System.out.println("주인 없는 노트");
				System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
			} else {
			
			System.out.println("■ ■ ■ ■ ■ ■ 노트 정보 ■ ■ ■ ■ ■ ■");
			System.out.printf("소유자 : %s\n특성 : %s %s %s노트\n가격 : %,d원\n"
					, this.owner
					, this.color
					, checkpage(page)
					, this.size
					, checkprice(size, color, page));
			
			System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
			
			}
			return "";
		}
		
		private int checkprice(String size, String color, int page) {
			int total = 500;
			if (size == "A3") {
				total += 400;
			} else if (size == "A4") {
				total += 200;
			} else if (size == "B3") {
				total += 500;
			} else if (size == "B4") {
				total += 300;
			} else if (size == "B5") {
				total += 100;
			}
			
			total = checkcolor(color, total);
			
				total += (page - 10) * 10;
			
			return this.price = total;
		}

		private int checkcolor(String color, int total) {
			if(color == "검정색") {
				total += 100;
			} else if (color == "노란색") {
				total += 200;
			} else if (color == "파란색") {
				total += 200;
			}
			
			return total;
		}

		private String checkpage(int n) {
			if(n >= 10 && n <= 50) {
				return "얇은";
			} else if (n <= 100) {
				return "보통";
			} else {
				return "두꺼운";
			}
			
		}
	}


















