package com.project.dentist.patient;

import java.util.Scanner;
import com.project.dentist.Output;
import com.project.dentist.dataClass.Dentist;
import com.project.dentist.patient.medicalHistory.MedicalHistory;
import com.project.dentist.patient.patientInfo.PatientInfo;

public class PatientOutput {

	
	public static void introduce() {
		
		Output.subMenuStart("병원 소개");
		String[] menu = { "기본 정보", "의료진 정보", "상위메뉴"};
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
public static void printIntro() {
		
		Output.subMenuStart("병원 기본 정보");
		System.out.printf("  [소개글] 안녕하세요, %s입니다.\n", Dentist.name);
		System.out.println("  [내용] 믿을 수 있는 의료진, 믿을 수 있는 장비,");
		System.out.println("        환자의 안전을 최우선으로 생각하는 바른치과!");
		System.out.printf("  [위치] %s\n", Dentist.address);
		System.out.printf("  [전화번호] %s\n", Dentist.phoneNum);
		Output.subMenuEnd();
	}
	
	public static void medicalinfo() {
		Output.subMenuStart("내 진료 정보");
		String menu[] = {"내 정보 조회","내 정보 수정","진료 내역","상위메뉴"};
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
	public static void medicalinfomenu() {
		String input;
		Scanner scan = new Scanner(System.in);
		boolean subLoop = true;
		while (subLoop) {
			PatientOutput.medicalinfo();

			System.out.println();

			System.out.print("번호 입력: ");
			
			input = scan.nextLine();

			if (input.equals("1")) {

				PatientInfo.view();
			} else if (input.equals("2")) {
				PatientInfo.edit();
			} else if (input.equals("3")) {
				MedicalHistory.view();
			}else if (input.equals("0")) {

				subLoop = false;

			} else {

				System.out.println("올바른 번호를 입력하세요.");
			}
		}
	}
	
	public static void appoint() {
		Output.subMenuStart("진료 예약");
		String[] menu = { "예약하기", "예약 변경", "예약 취소", "상위메뉴"};
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
	
	public static void review() {
		
		Output.subMenuStart("진료 후기");
		String[] menu = { "진료 후기 조회", "진료 후기 작성", "상위메뉴" };
		Output.subMenuContent(menu);
		Output.subMenuEnd();
	}
	
	public static void pause() {

		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		
		//프로그램 일시 정지
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine(); //블럭에 걸림 = 일시정지
		
	}
	


}
