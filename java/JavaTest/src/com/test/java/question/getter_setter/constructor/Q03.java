package com.test.java.question.getter_setter.constructor;

public class Q03 {

	public static void main(String[] args) {

		// 포장하는 직원
		Packer packer = new Packer();

		// 연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);

		Pencil p2 = new Pencil();
		p2.setHardness("4B");
		packer.packing(p2);

		// System.out.println(p1.info());
		// System.out.println(p2.info());


		// 지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);

		// System.out.println(e1.info());

		// 볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);

		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1.5);
		b2.setColor("red");
		packer.packing(b2);

		// System.out.println(b1.info());
		// System.out.println(b2.info());

		// 자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);

		// System.out.println(r1.info());

		// 결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);

	} // main

}// Q03


class Packer {
	private static int pencilCount;
	private static int eraserCount;
	private static int ballPoinPenCount;
	private static int rulerCount;


	void packing(Pencil pencil) {
		if (pencil.getHardness().equals("4B") || pencil.getHardness().equals("3B")
				|| pencil.getHardness().equals("2B") || pencil.getHardness().equals("B")
				|| pencil.getHardness().equals("HB") || pencil.getHardness().equals("H")
				|| pencil.getHardness().equals("2H") || pencil.getHardness().equals("3H")
				|| pencil.getHardness().equals("4H")) {
			System.out.println(pencil.info());
			System.out.println("포장을 완료했습니다.");
			pencilCount++;
		} else {
			System.out.println("올바르지 않은 흑연 등급입니다.");
		}

	}

	public void packing(Eraser eraser) {
		if (eraser.getSize().equals("Large") || eraser.getSize().equals("Medium")
				|| eraser.getSize().equals("Small")) {
			System.out.println(eraser.info());
			System.out.println("포장을 완료했습니다.");
			eraserCount++;
		} else {
			System.out.println("올바르지 않은 지우개 크기입니다.");
		}
	}

	public void packing(BallPointPen ballpointpen) {
		if (ballpointpen.getThickness() == 0.3 || ballpointpen.getThickness() == 0.5
				|| ballpointpen.getThickness() == 0.7 || ballpointpen.getThickness() == 1.0
				|| ballpointpen.getThickness() == 1.5) {
			if (ballpointpen.getColor().equals("red") || ballpointpen.getColor().equals("blue")
					|| ballpointpen.getColor().equals("green")
					|| ballpointpen.getColor().equals("black")) {
				System.out.println(ballpointpen.info());
				System.out.println("포장을 완료했습니다.");
				rulerCount++;
			} else {
				System.out.println("올바르지 않은 볼펜 색상입니다.");
				return;
			}
		} else {
			System.out.println("올바르지 않은 볼펜 두께입니다.");
		}

	}

	public void packing(Ruler ruler) {
		if ((ruler.getLength() == 30 || ruler.getLength() == 50 || ruler.getLength() == 100)
				&& (ruler.getShape().equals("줄자") || ruler.getShape().equals("운형자")
						|| ruler.getShape().equals("삼각자"))) {
			System.out.println(ruler.info());
			System.out.println("포장을 완료했습니다.");
			ballPoinPenCount++;
		} else {
			System.out.println("올바르지 않은 자 길이나 형태입니다.");
		}

	}

	public void countPacking(int i) {
		System.out.println("\n=====================");
		System.out.println("포장 결과");
		System.out.println("=====================");

		if (i == 0) {
			System.out.printf("연필 %d회\n지우개 %d회\n볼펜 %d회\n자 %d회\n", pencilCount,
					eraserCount, ballPoinPenCount, rulerCount);
		} else if (i == 1) {
			System.out.printf("연필 %d회\n", pencilCount);
		} else if (i == 2) {
			System.out.printf("지우개 %d회\n", eraserCount);
		} else if (i == 3) {
			System.out.printf("볼펜 %d회\n", ballPoinPenCount);
		} else if (i == 4) {
			System.out.printf("자 %d회\n", rulerCount);
		}
		
		/* 
		 	
		 	if (i == 0 || i == 1) System.out.printf("연필 %d회\n", Packer.pencilCount);
		 	if (i == 0 || i == 2) System.out.printf("연필 %d회\n", Packer.eraserCount);
		 	if (i == 0 || i == 3) System.out.printf("연필 %d회\n", Packer.ballPoinPenCount);
		 	if (i == 0 || i == 4) System.out.printf("연필 %d회\n", Packer.rulerCount);
		 
		 
		 */

	}

}


class Pencil {
	private String hardness;

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	String info() {
		return String.format("포장 전 검수 : %s 진하기 연필입니다.", this.hardness);
	}

}


class Eraser {

	private String size;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	String info() {
		return String.format("포장 전 검수 : %s 사이즈 지우개입니다.", this.size);
	}

}


class BallPointPen {

	private double thickness;
	private String color;

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	String info() {
		return String.format("포장 전 검수 : %s 색상 %.1fmm 볼펜입니다.", this.color, this.thickness);
	}

}


class Ruler {

	private int length;
	private String shape;


	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	String info() {
		return String.format("포장 전 검수 : %dcm %s입니다.", this.length, this.shape);
	}

}


