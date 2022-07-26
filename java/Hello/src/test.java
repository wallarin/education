import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

	public static String nName() {

		List<String> 성 = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "임", "한", "오", "서", "신", "권", "황", "안", "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "주", "나", "강","추", "노","소", "신", "주","장", "남"); 

		List<String> 이름 = Arrays.asList("경", "빈", "나", "라", "민", "우", "지", "호", "이", "수", "지", "희", "동", "수", "혁", "호", "경", "미", "도", "희", "대", "기", "윤", "진", "민", "지", "정", "숙"); Collections.shuffle(성); 

		Collections.shuffle(이름); 

		return 성.get(0) + 이름.get(0) + 이름.get(1); 
		} 
	public static void main(String[] args) { // 이름 
		for (int i = 0; i < 150; i++) {
			System.err.println(nName()+""); 
		} 
	} 
}

