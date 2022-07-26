package com.test.java.io;

import java.io.File;

public class Q10 {
	
	public static void main(String[] args) {
		
		File dir = new File("C:\\Users\\dnfkt\\Desktop\\파일_디렉토리_문제 (2)\\직원");
		
		File[] list = dir.listFiles();
		
		for (File file : list) {
			if(file.isFile()) {
				
				String filename = file.getName();
				
				//System.out.println(filename);
				
				//Parsing : 의미있는 부분들을 나누는 작업
				
				//"홍길동_2022_11.txt"; > 홍길동 : 2022 : 11
				//"홍길동__2022_11.txt"; > 홍길동 : 빈방 : 2022 : 11
				
				
				filename = filename.replace("__", "_"); //만약 언더라인이 2개면 언더라인을 하나로 변경
				
				String[] temp = filename.split("_");
				//0번방은 직원명
				//1번방은 년도
				
				File newDirectory = new File(dir.getAbsolutePath() + "\\" + temp[0] + "\\" + temp[1]);
				
				newDirectory.mkdirs();
				
				File moveFile = new File(newDirectory.getAbsolutePath() + "\\" + file.getName());
				file.renameTo(moveFile);
				
				
			}
		}
		System.out.println("이동 완료");
		
	}

}













