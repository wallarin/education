package com.test.java.question.file_dir;

import java.io.File;

public class Q08 {

	private static int fileCount = 0;
	private static int dirCount = 0;

	public static void main(String[] args) {

		String path = "C:\\class\\파일_디렉토리_문제\\폴더 삭제";
		File dir = new File(path);

		if (dir.exists()) {
			countFile(dir);

			System.out.println("폴더를 삭제했습니다.");
			System.out.printf("삭제된 폴더는 %d개이고, 파일은 %d개입니다.", dirCount, fileCount);
		}

	}

	private static void countFile(File dir) {

		File[] list = dir.listFiles();

		for (File subfile : list) {

			if (subfile.isDirectory()) { // 먼저 폴더인지를 확인한다. 폴더라면
				countFile(subfile); // 다시 자신을 호출
				subfile.delete(); // 다시 자신을 호출했을때 디렉토리면 삭제된다.
				dirCount++;
			} else if (subfile.isFile()) { // 다시 자신을 호출했을때 파일이라면 삭제
				subfile.delete();
				fileCount++;
			}
		}

	}

}
