package com.test.java.question.file_dir;

import java.io.File;
import java.util.Scanner;

public class Q02 {

	public static void main(String[] args) {

		System.out.print("폴더: ");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();

		System.out.print("확장자: ");
		String file_extension = scanner.nextLine().toLowerCase();

		File file = new File(path);

		if (file.exists()) {
			File[] list = file.listFiles();

			// 폴더안의 내용의 확장자명을 알아서 추출하는 방법
			for (File d : list) {
				String filename = d.getName().substring(d.getName().lastIndexOf(".") + 1);
				// 파일네임 이라는 변수에 File의 이름을 가져온 뒤 그 이름에서 뒤에서부터 .을 탐색한다.
				// 만약 그 탐색과 입력한 확장자가 같으면 출력
				if (file_extension.equals(filename.toLowerCase())) {
					System.out.println(d.getName());
				}
			}

		}

	}

}
