package com.test.java.question.file_in_out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Q03 {

	public static void main(String[] args) {

		ArrayList<String> pass = new ArrayList<String>();
		ArrayList<String> unpass = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\성적.dat"));

			String line = null;

			while ((line = reader.readLine()) != null) { // 파일을 하나씩 읽는다.
				String[] parsing = line.split(","); // ,를 기준으로 파싱해서 배열에 담는다.
				int kor = Integer.parseInt(parsing[1]); // 파싱한 1번방이 국어점수
				int eng = Integer.parseInt(parsing[2]); // 2번방 영어점수
				int math = Integer.parseInt(parsing[3]); // 3번방 수학점수

				if (kor >= 40 && eng >= 40 && math >= 40) { // 1차로 각각의 점수가 40점 미만인 사람을 거른다.
					if ((kor + eng + math) / 3 >= 60) { // 2차 조건으로 평균이 60점인지 확인한다.
						pass.add(parsing[0]); // 1차 2차 모두 통과시 합격 리스트에 담아준다.
					} else {
						unpass.add(parsing[0]); // 2차 조건에 부합하지 않으면 1차에서 담았던 불합격 리스트에 담아준다.
					}
				} else {
					unpass.add(parsing[0]); // 1차 조건에서 맞지 앉는 사람은 불합격 리스트에 담아준다.
				}

			}

			reader.close(); // 사용이 끝났으므로 닫아준다.

			System.out.println("[합격자]");
			for (String p : pass) {
				System.out.println(p); // 담아준 합격자 리스트를 출력한다.
			}
			System.out.println();
			System.out.println("[불합격자]");
			for (String up : unpass) {
				System.out.println(up); // 담아준 불합격자 리스트를 출력한다.
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
