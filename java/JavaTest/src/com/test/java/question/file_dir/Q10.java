package com.test.java.question.file_dir;

import java.io.File;

public class Q10 {

	public static void main(String[] args) {

		String path = "C:\\class\\파일_디렉토리_문제\\직원";
		File file = new File(path);

		if (file.exists()) {
			newDir(file);
			System.out.println("분류가 완료되었습니다.");
		}

	}// main

	private static void newDir(File file) {
		File[] list = file.listFiles();
		for (File f : list) {
			if (f.isFile()) {
				String[] tmp = f.getName().split("_"); // list에서 "_"을 기준으로 추출한다
				String dirPath = file + "\\" + tmp[0] + "\\" + tmp[1]; // 기존 주소에서 추출한 값을 기준으로 폴더를
																		// 생성한다.
				File dir = new File(dirPath);
				dir.mkdirs();

				String filePath = dirPath + "\\" + f.getName(); // list의 이름을 가져와 주소에 저장한다.
				File moveFile = new File(filePath);
				f.renameTo(moveFile);
			}
		} // for
	}
}// Q10
