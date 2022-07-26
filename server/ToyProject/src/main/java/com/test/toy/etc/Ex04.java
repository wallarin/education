package com.test.toy.etc;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex04 {
	
	public static void main(String[] args) throws Exception {
		
		//String url = "http://lms1.sist.co.kr/worknet/SMember/index.asp?strCode=I202203010019";
		//Document doc = Jsoup.connect(url).get();
		//System.out.println(doc.html());
		
		/*
		
			Jsoup 방식
			- 인증이 불필요한 페이지에서 사용 가능
			- 인증이 필요한 페이지에서 사용 불가능 > 고비용
			- JavaScript 실행이 필요한 페이지에서 사용 불가능 > Ajax 페이지
			
			
			웹 응용 프로그램 자동화 프로그램
			- 셀레니움
			- 사람 대신에 프로그램이 사람처럼 웹 사이트에 방문해서 여러가지 행동을 하는 프로그램
			- 크롤링을 하기 위한 프로그램은 아니다. 사람이 서핑하는것과 동일하게 동작하는 프로그램이다.
			- 크롤링 작업도 가능하다.
			- 인증이 필요한 페이지에서 사용 가능
			- JavaScript 실행이 필요한 페이지에서 사용 가능
			- 준비물 > 드라이버 > 브라우저 종류 + 버전
		
		*/
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}

	private static void m4() {

		//jsoup으로는 불가능 > selenium으로 해결해야함
		//#menuGroup_0 > article > div > ul > li:nth-child(2) > div > em > strong
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        
        WebDriver driver = new ChromeDriver(options);
        
        String url = "https://www.banapresso.com/menu";
        
        
        driver.get(url);
        //#menuGroup_0 > article > div > ul > li:nth-child(1) > div > em > strong
        
        List<WebElement> list = driver.findElements(By.cssSelector(".menu_list_cont li"));
        
        System.out.println(list.size());
        
        List<WebElement> imglist = driver.findElements(By.cssSelector(".menu_box > .img"));
        List<WebElement> e_name = driver.findElements(By.cssSelector(".menu_name > strong"));
        List<WebElement> k_name = driver.findElements(By.cssSelector(".menu_name > i"));

        
        for (WebElement e : list) {
        	System.out.println("img = " + e.findElement(By.cssSelector(".menu_box > .img > img")).getAttribute("src"));
        	System.out.println("English = " + e.findElement(By.cssSelector(".menu_name > strong")).getText());
        	System.out.println("Korea = " + e.findElement(By.cssSelector(".menu_name > i")).getText());
        	System.out.println();
        }
        
        //System.out.println(e_name.toString());
		
	}

	private static void m3() throws Exception {

		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        
        WebDriver driver = new ChromeDriver(options);
        
        String url = "http://lms1.sist.co.kr/worknet/SLogin.asp";
        
        driver.get(url);
        
        WebElement id = driver.findElement(By.id("strLoginID"));
        id.sendKeys("백재민");
        
        WebElement pwd = driver.findElement(By.id("strLoginPwd"));
        pwd.sendKeys("3900");
        
        WebElement btn = driver.findElement(By.cssSelector(".login-btn > input"));
        btn.click();
        
        //url = "http://lms1.sist.co.kr/worknet/SMember/index.asp?strCode=I202203010019";
		WebElement td = driver.findElement(By.cssSelector("#content > div > div > div > div.panel-body > form > table > thead > tr:nth-child(5) > td:nth-child(2)"));
		
		System.out.println("나의 교육기간: " + td.getText());
		
		/* 네트워크 속도가 자바의 속도보다 느릴때 사용
		try {
	         WebElement eID = new  WebDriverWait(driver, 10).until( 
	               ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content tr:nth-child(5) > td:nth-child(2)")) ); //사용할때 선택자 변경
	         
	         System.out.println("나의 교육 기간: " + eID.getText()); //필요에 따라 값 수정

	      } catch (Exception e) {
	         System.out.println("> 오류 발생 + " + e.toString());
	      }
	     */
		
	}

	private static void m2() {

		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		
		//client-combined-3.141.59.jar
		ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        
        
        //브라우저 + 사람
        WebDriver driver = new ChromeDriver(options);

        String url = "http://localhost:8090/toy/etc/expage.do";
        
        driver.get(url);
        
        WebElement name =  driver.findElement(By.id("name"));
        
        System.out.println(name.getText());
        
	}

	private static void m1() throws Exception {
		
		//jsoup은 프로그램의 실행전의 소스만을 읽는다.
		
		String url = "http://localhost:8090/toy/etc/expage.do";
		
		Document doc = Jsoup.connect(url).get();
		
		Element span = doc.selectFirst("body > main > section > div > span");
		
		System.out.println(span.text());
		
		Element span2 = doc.selectFirst("#name");
		
		System.out.println(span2.text());
		
	}

}




















