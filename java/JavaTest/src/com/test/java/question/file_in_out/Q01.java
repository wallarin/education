package com.test.java.question.file_in_out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Q01 {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\파일_입출력_문제\\이름수정.dat"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\파일_입출력_문제\\이름수정_변환.dat"));

			String line = null;

			while ((line = reader.readLine()) != null) {
				writer.write(line.replace("유재석", "메뚜기")); //.replaceAll을 써야하나 했는데 아니였다
				writer.newLine();
			}
			writer.close();
			reader.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");

		} catch (Exception e) {
			System.out.println("Q01.main");
			e.printStackTrace();
		}

	}

}
