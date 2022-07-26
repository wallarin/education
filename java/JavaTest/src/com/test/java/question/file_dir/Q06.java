package com.test.java.question.file_dir;

import java.io.File;

public class Q06 {

	public static void main(String[] args) {
		int count = 0;
		String path = "C:\\class\\파일_디렉토리_문제\\파일 제거";

		File file = new File(path);

		if (file.exists()) {
			File[] list = file.listFiles();

			for (int i = 0; i < list.length; i++) {
				if (list[i].length() == 0) {
					list[i].delete();
					count++;
				}
			}
		}
		System.out.printf("총 %d개의 파일을 삭제했습니다.", count);
	}// main

}
