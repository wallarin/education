package com.test.java.question.file_in_out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Q02 {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\숫자.dat"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\파일_입출력_문제\\숫자_변환.dat"));

			String line = null;

			while ((line = reader.readLine()) != null) {

				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) >= '0' && line.charAt(i) <= '9') { // 읽는 라인의 문자가 48~56 사이의 값을 가진다면
						line = line.replace(line.charAt(i), chKor(line.charAt(i))); // 그 값을 chKor 메소드의 문자로 변경
					}
				}
				writer.write(line); // 바뀌거나 바뀌지 않은 문자라인을 적어준다.
				writer.newLine();
			}

			reader.close();
			writer.close();
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static char chKor(char i) {

		switch (i) {
		case 48:
			return '영';
		case 49:
			return '일';
		case 50:
			return '이';
		case 51:
			return '삼';
		case 52:
			return '사';
		case 53:
			return '오';
		case 54:
			return '육';
		case 55:
			return '칠';
		case 56:
			return '팔';
		default:
			return '구';
		}

	}

}
