package com.test.java.question.file_dir;

import java.io.File;
import java.util.Scanner;

public class Q03 {

	public static void main(String[] args) {

		System.out.println("파일 이동을 실행합니다");

		File file = new File("C:\\class\\java\\file\\AAA\\test.txt");
		File move_File = new File("C:\\class\\java\\file\\DDD\\test.txt");

		if (file.exists()) {
			boolean move = file.renameTo(move_File);

			if (move == false) { // 이동이 실패한다면

				System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n) ");
				Scanner scanner = new Scanner(System.in);
				String y_N = scanner.nextLine().toLowerCase();

				if (y_N.equals("y")) {
					move_File.delete();
					file.renameTo(move_File);
					System.out.println("y. 파일을 덮어썼습니다.");
				} else if (y_N.equals("n")) {
					System.out.println("n. 작업을 취소합니다.");
				}

			}

		} else {
			System.out.println("원본 파일이 존재하지 않습니다.");
		}

	}// main

}
