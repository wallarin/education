package com.test.java.question.file_dir;

import java.io.File;
import java.util.ArrayList;

public class Q09 {

	public static ArrayList<File> all_File = new ArrayList<File>();

	public static void main(String[] args) {

		String path = "C:\\class\\파일_디렉토리_문제\\크기 정렬";
		File file = new File(path);


		if (file.exists()) {
			add_File(file);
		} else {
			System.out.println("존재하지 않는 폴더입니다.");
		}

		bubble(all_File);

		System.out.println("[파일명]\t\t\t\t[크기]\t  [파일이 들어있는 폴더]");

		for (File result : all_File) {
			System.out.printf("%-24s\t%s\t\t%3s\n", result.getName(), checkSize(result.length()),
					result.getParentFile().getName());
		}

	}

	private static String checkSize(long size) {

		// B KB MB GB TB 구하기 생각
		if (size >= 1024) {
			long KB = size / 1024;
			if (KB >= 1024) {
				long MB = KB / 1024;
				if (MB >= 1024) {
					long GB = MB / 1024;
					if (GB >= 1024) {
						long TB = GB / 1024;
						return TB + "TB";
					} else {
						return GB + "GB";
					}
				} else {
					return MB + "MB";
				}
			} else {
				return KB + "KB";
			}
		} else {
			return size + "B";
		}
	}

	private static void bubble(ArrayList<File> all_File) {
		for (int i = 0; i < all_File.size() - 1; i++) {

			for (int j = 0; j < all_File.size() - i - 1; j++) {

				if (all_File.get(j).length() < all_File.get(j + 1).length()) {
					File temp = all_File.get(j + 1);
					all_File.set(j + 1, all_File.get(j));
					all_File.set(j, temp);
				}

			}
		}

	}

	private static void add_File(File file) {

		File[] list = file.listFiles();

		for (File subdir : list) {
			if (subdir.isDirectory()) {
				add_File(subdir);
			} else {
				all_File.add(subdir);
			}
		}

	}

}
