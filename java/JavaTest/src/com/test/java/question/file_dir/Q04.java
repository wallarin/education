package com.test.java.question.file_dir;

import java.io.File;

public class Q04 {

	public static void main(String[] args) {

		// for문 이용??
		// 파일들을 하나씩 가져온다
		// 가져온 파일의 이름에 "[%00d] %s", i, 파일이름

		String PATH = "C:\\class\\파일_디렉토리_문제\\음악 파일\\Music";
		File dir = new File(PATH);

		if (dir.exists()) {
			File[] list = dir.listFiles();

			for (int i = 0; i < list.length; i++) {
				String fileName = list[i].getName();
				String newFileName = String.format(PATH + "\\[%03d]%s", i + 1, fileName); 
																				//fileName 대신에 list[i].getName()을 적으면 20라인이 필요X
				File file = new File(newFileName);

				list[i].renameTo(file);

				System.out.println(file.getName());

			}
		}

	}// main

}
