package com.test.java.question.getter_setter;

public class Q01 {
	
	public static void main(String[] args) {
		
		Book b1 = new Book();

		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1022);

		System.out.println(b1.info());
		
	}

}

class Book {
	   private String title;
	   private int price;
	   private String author;
	   private String publisher;
	   private String pubYear = "2019";
	   private String isbn;
	   private int page;


	   public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		
				if (checktitle(title)) { //유효성 검사 어떻게??
					this.title = title;
				} else {
					System.out.println("올바르지 않은 제목입니다.");
				}
			
		}


		private boolean checktitle(String title) { //유효성 검사 어떻게??
			if (title.length() > 50) {
				return false;
			}
			
			for (int i = 0; i < title.length(); i++) {
				
				char t = title.charAt(i);
				
				if ((t < '가' || t > '힣') 
						&& (t < 'A' || t > 'Z') 
						&& (t < 'a' || t > 'z') 
						&& (t < '0' || t > '9') 
						&& (t != ' ')){
					return false;
				} 
			}
			return true;
		}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		if (price >= 0 && price <= 1000000) {
			this.price = price;
		} else {
			System.out.println("가격이 올바르지 않습니다.");
		}
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		if (page > 0) {
			this.page = page;
		} else {
			System.out.println("페이지 오류");
		}
	}


	public String getPubYear() {
		return pubYear;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String info() {
		
		StringBuilder sb = new StringBuilder();
		
//		sb.append("제목: " + this.title);
//		sb.append("\r\n");
//		sb.append(String.format("가격: %,d원", this.price));
//		sb.append("\r\n");
//		sb.append("저자: " + this.author);
//		sb.append("\r\n");
//		sb.append("출판사: " + this.publisher);
//		sb.append("\r\n");
//		sb.append(String.format("발행년도: %s", this.pubYear));
//		sb.append("\r\n");
//		sb.append("ISBN: " + this.isbn);
//		sb.append("\r\n");
//		sb.append(String.format("페이지: %d년", this.page));
		
		
		System.out.printf("제목: %s\n가격: %,d원\n저자: %s\n출판사: %s\n발행년도: %s년\nISBN: %s\n페이지: %,d장"
				, this.title
				, this.price
				, this.author
				, this.publisher
				, this.pubYear
				, this.isbn
				, this.page);
		
	         return sb.toString(); //여기 return 에는 어떤게 들어가야 할까???
	   }
	}
