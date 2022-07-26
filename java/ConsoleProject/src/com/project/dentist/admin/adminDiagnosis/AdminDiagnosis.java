package com.project.dentist.admin.adminDiagnosis;

import java.util.Scanner;
import com.project.dentist.Output;

public class AdminDiagnosis {
	
	private Scanner scan; 
	
	public AdminDiagnosis() {
		this.scan = new Scanner(System.in);
	}
	
	
	public void main() {
		
		DiagnosisSearch search = new DiagnosisSearch();
		DiagnosisWrite write = new DiagnosisWrite();
		
		boolean loop = true;
		
		while (loop) {
			
			Output.subMenuStart("환자 진료 정보");
			String[] menu = {"진료 정보 검색", "진료 정보 작성", "상위메뉴"}; 
			Output.subMenuContent(menu);
			Output.subMenuEnd();
			
			System.out.print("번호 입력: ✎");
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				search.main();
			} else if (input.equals("2")) {
				write.main();
			} else if (input.equals("0")) {
				loop = false;
			} else {
				System.out.println("잘못된 번호입니다.");
			}
			
			System.out.println();
		}
	
	}
}