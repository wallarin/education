package com.test.java.question.file_dir;

import java.io.File;

public class Q07 {

	// Hashset 어떻게 사용해야할까??

	public static void main(String[] args) {

		String path = "C:\\class\\파일_디렉토리_문제\\동일 파일\\MusicA";
		String path2 = "C:\\class\\파일_디렉토리_문제\\동일 파일\\MusicB";

		File musicA = new File(path);
		File musicB = new File(path2);

		if (musicA.exists() && musicB.exists()) {
			File[] m1 = musicA.listFiles();
			File[] m2 = musicB.listFiles();

			for (int i = 0; i < m1.length; i++) {
				for (int j = 0; j < m2.length; j++) {

					if (m1[i].getName().equals(m2[j].getName())) {
						System.out.println(m1[i].getName());
					}

				}
			}
		}

	}

}


