package com.test.java.io;

import java.io.File;

public class Q08 {

	public static void main(String[] args) {

		File dir = new File("C:\\Users\\dnfkt\\Desktop\\파일_디렉토리_문제 (2)\\폴더 삭제\\delete");

		// dir.delete();

		deleteDirectory(dir);

	}

	private static void deleteDirectory(File dir) {

		// 1.모든 파일을 담는다.
		File[] list = dir.listFiles();

		// 2. 파일들만 찾아낸다.
		for (File f : list) {
			if (f.isFile()) {
				f.delete();
			}
		}

		// 3. 자식 폴더가 있는지 찾는다.
		for (File d : list) {
			if (d.isDirectory()) {
				deleteDirectory(d); //자식 폴더가 있으면 재귀호출한다.
			}
		}

		// 여기까지 도달 > dir이 빈 폴더가 되었음
		dir.delete();

	}

}
