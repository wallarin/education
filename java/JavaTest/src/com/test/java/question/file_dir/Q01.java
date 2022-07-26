package com.test.java.question.file_dir;

import java.io.File;
import java.util.Scanner;

public class Q01 {

	public static void main(String[] args) {

		System.out.print("파일 경로: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		String path = input;

		File file = new File(path);

		if (file.exists()) {
			System.out.println();
			System.out.println("파일명: " + file.getName());
			checkFile(path);
			System.out.println(checkSize(file.length()));


		} else {
			System.out.println("존재하지 않는 파일입니다.");
		}
	}

	private static String checkSize(long size) {

		// B KB MB GB TB 구하기 생각
		if (size > 1024) {
			double KB = size / 1024.0;
		if (KB > 1024) {
			double MB = KB / 1024.0;
		if (MB > 1024) {
			double GB = MB / 1024.0;
		if (GB > 1024) {
			double TB = GB / 1024.0;
			return String.format("파일 크기: %.1fTB", TB);
			} else {
				return String.format("파일 크기: %.1fGB", GB);
			}
				} else {
					return String.format("파일 크기: %.1fMB", MB);
				}
			} else {
				return String.format("파일 크기: %.1fKB", KB);
			}
		} else {
			return String.format("파일 크기: %.1fB", size);
		}
	}

	private static void checkFile(String path) {
		int index = path.lastIndexOf(".");

		String filename = path.substring(index + 1, path.length());

		System.out.println("종류: " + filename + " 파일");
	}

}
