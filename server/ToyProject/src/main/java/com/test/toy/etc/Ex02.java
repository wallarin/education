package com.test.toy.etc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("[네이버 영화 랭킹]");

		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.naver";
		
		Document doc = Jsoup.connect(url).get();
		
		//System.out.println(doc.title());
		
		//가장 중요한 작업 내가 가져올 값의 해당 태그를 찾기
		Elements list = doc.select(".tit3 > a");
		
		
		System.out.println(list.size()); //50이라고 결과가 출력 > 제목만 잘 찾았다고 생각
		
		for (Element item : list) {
			
			System.out.println(item.text()); //PCDATA
			System.out.println(item.attr("href")); //속성
			
		}
		
	}

}
















