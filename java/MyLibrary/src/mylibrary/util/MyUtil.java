package mylibrary.util;

import java.util.Random;

public class MyUtil {

	//요구사항] 난수 10~20 사이의 x N회
	public int getNum() {
		Random rnd = new Random();
		return rnd.nextInt(11) + 10;
	}
	
}
