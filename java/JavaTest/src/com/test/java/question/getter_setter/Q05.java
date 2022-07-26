package com.test.java.question.getter_setter;

public class Q05 {
	
	public static void main(String[] args) {
		
		Box box1 = new Box();

		box1.cook();
		box1.check();
		box1.list();
		
	} //main
}//Q05


class Box {
	   private Macaron[] list = new Macaron[10];

	   public void cook() {
		   for (int i = 0; i < list.length; i++) { // i < 10 은 별로 i < list.length 로 만드는게 좋다.
			   Macaron m = new Macaron();
			   
			   int n = (int)(Math.random() * 11) + 5;
			   
			   m.setSize(n);
			   
			   String[] color = { "red", "blue", "yellow", "white", "pink", "purple", "green", "black"};
			   n = (int)(Math.random() * color.length);
			   
			   m.setColor(color[n]);
			   
			   n = (int)(Math.random() * 20) + 1;
			   
			   m.setThickness(n);
			   
			   this.list[i] = m;
			   
//			   this.list[i].setSize((int)(Math.random() * 11 + 5));
//			   list[i].setColor((int)(Math.random() * 8));
//			   list[i].setThickness((int)(Math.random() * 20 + 1));
		   }
		  System.out.println("마카롱을 " + list.length +"개 만들었습니다.");
		  System.out.println();
		  
	   }
	   
		public void check() {
			int pass = 0;
			int fail = 0;
			for (int i = 0; i < this.list.length; i++) {
				
				Macaron m = this.list[i];
				
				if(checkMacaron(m)) { // 유효성 검사를 메소드로 따로 빼줌
					pass++;
				} else {
					fail++;
				}
				
//				if (m.getSize() > 7 && m.getSize() < 15 && m.getColor() != "black"
//						&& m.getThickness() > 2 && m.getThickness() < 19) {
//					pass++;
//					list[i].setPass("합격");
//				} else {
//					fail++;
//					list[i].setPass("불합격");
//				}
			}
			System.out.println("[박스 체크 결과]");
			System.out.printf("QC 합격 개수: %d개\n", pass);
			System.out.printf("QC 합격 개수: %d개\n", fail);
			System.out.println();
		}
	   
	   private boolean checkMacaron(Macaron m) {
		   if (m.getSize() < 8 || m.getSize() > 14) {
			   return false;
		   }
		   
		   if (m.getColor().equals("black")) {
			   return false;
		   }
		   
		   if (m.getThickness() < 3 || m.getThickness() > 18) {
			   return false;
		   }
		   		return true;
		}

	public void list() {
		   System.out.println("[마카롱 목록]");
		   for (int i = 0; i < this.list.length; i++) {
			   
			   Macaron m = this.list[i];
			   System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : %s\n"
					   				, (i+1)
					   				, m.getSize()
					   				, m.getColor()
					   				, m.getThickness()
					   				, checkMacaron(m) ? "합격" : "불합격")			   						;
					   
//			   System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : %s\n"
//					   , i+1
//					   , list[i].getSize()
//					   , list[i].getColor()
//					   , list[i].getThickness()
//					   , list[i].getPass());
		   }
	   }
	   
	}

	class Macaron {
	   private int size;
	   private String color;
	   private int thickness;
	   private String pass;
	   
	   //getter / setter 안에서 랜덤 함수를 안만드는 이유?? > 유효성 검사는 한다 but 업무 코드는 하지 않기때문에...
	   //다른 사람들도 안에서 만든다고 상상하지 않는다.
	   
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) { //int color
		//String을 int로 바꿔 안에 배열을 String이 아닌 int형으로 뽑아내서 문자형으로 변경됨
//		String[] mColor = new String[] { "red", "blue", "yellow", "white", "pink", "purple", "green", "black"};
//		this.color = mColor[color]; //color = int / mColor = String 값으로 들어감
		this.color = color;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	   
	   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	