package com.test.java.io;

import java.io.File;
import java.util.ArrayList;

public class Q09 {
	
	public static void main(String[] args) {
		
		File dir = new File("C:\\Users\\dnfkt\\Desktop\\파일_디렉토리_문제 (2)\\크기 정렬");
		ArrayList<File> flist = new ArrayList<File>();
		
		searchFile(dir, flist);
		
		//크기순 정렬 > 버블 정렬
		for(int i=0; i<flist.size() - 1; i++) {
			for (int j = 0; j <flist.size() - i - 1; j++) {
				
				if (flist.get(j).length() < flist.get(j+1).length()) {
					
					File temp = flist.get(j);
					flist.set(j, flist.get(j+1));
					flist.set(j+1, temp);
					
				}
				
			}
		}
		
		for (File f : flist) {
			System.out.println(f.getParent().replace("C:\\Users\\dnfkt\\Desktop\\파일_디렉토리_문제 (2)\\크기 정렬\\", "") + ">" + f.getName() + "::" + f.length());
		}
		
	}

	private static void searchFile(File dir, ArrayList<File> flist) {
		
		File[] list = dir.listFiles();
		
		for (File f : list) {
			if(f.isFile()) {
				flist.add(f);
			}
		}
		
		for (File d : list) {
			if(d.isDirectory()) {
				searchFile(d, flist);
			}
		}
		
	}

}
