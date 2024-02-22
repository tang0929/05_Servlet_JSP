package edu.kh.jsp.model.dto;

public class Book {
	// 필드 지정
	private String title;
	private String writer;
	private int price;
	
	// 기본생성자(객체가 생성될때 시행되는 것)
	public Book() {}

	// 매개변수 생성자(alt shift o)
	public Book(String title, String writer, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	
	// getter setter 생성

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	// override
	@Override
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	

	
	
	
	

}
