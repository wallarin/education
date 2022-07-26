package com.test.java.question.getter_setter;

public class Q04 {

	public static void main(String[] args) {

		Employee e1 = new Employee();

		e1.setName("홍길동");
		e1.setDepartment("홍보부");
		e1.setPosition("부장");
		e1.setTel("010-1234-5678");
		e1.setBoss(null); // 직속 상사 없음 < 어떻게 해야할지 모르겠음..

		e1.info();


		Employee e2 = new Employee();

		e2.setName("아무개");
		e2.setDepartment("홍보부");
		e2.setPosition("사원");
		e2.setTel("010-2541-8569");
		e2.setBoss(e1); // 직속 상사 e1(홍길동)

		e2.info();


	}

}


class Employee {
	private String name;
	private String department;
	private String position;
	private String tel;
	private Employee boss; // boss = null > 주소값 변수가 비어있다.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (c < '가' || c > '힣') {
				System.out.println("올바르지 않은 이름");
			}
		}
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if (department.equals("영업부") || department.equals("기획부") || department.equals("총무부")
				|| department.equals("개발부") || department.equals("홍보부")) {
			this.department = department;
		} else {
			System.out.println("올바르지 않은 부서");
		}

	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if (position.equals("부장") || position.equals("과장") || position.equals("대리")
				|| position.equals("사원")) {
			this.position = position;
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		if (tel.startsWith("010")
				|| tel.charAt(3) == '-'
				&& tel.charAt(8) == '-'
				|| tel.length() == 13) {
			this.tel = tel;
//		if (tel.charAt(3) == '-' && tel.charAt(8) == '-') {
//			this.tel = tel;
		} else {
			System.out.println("'-'을 입력해주세요.");
		}
	}

	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		// java.lang.NullPointerException
		if (boss != null) {
			if (this.department.equals(boss.getDepartment())) {
				this.boss = boss;
			}
		}
	}

	public void info() {
		
		//선생님 코드 놓침
		String txt = String.format("[%s]\n-부서: %s\n- 직위: %s\n- 연락처: %s\n"
									, this.name
									, this.department
									, this.position
									, this.tel);
		txt += "- 직속상사: ";
		if (this.boss == null) {
		txt += "없음";
		} else {
			txt += String.format("%s(%s %s)"
					, boss.getName()
					, boss.getDepartment()
					, boss.getPosition());
		}
		
		System.out.println(txt);

//		System.out.printf("[%s]\n- 부서: %s\n- 직위: %s\n- 연락처: %s\n", this.name, this.department,
//				this.position, this.tel);
//
//		if (boss == null) {
//			System.out.print("- 직속상사: 없음\n");
//		} else if (this.department == boss.department) {
//			System.out.printf("- 직속상사: %s (%s %s)\n", this.boss.getName(),
//					this.boss.getDepartment(), this.boss.getPosition());
//		} else {
//			System.out.print("- 직속상사: 서로 다른 부서입니다.");
//		}

	}

}


