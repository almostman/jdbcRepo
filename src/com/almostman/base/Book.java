package com.almostman.base;
import java.util.Date;


public class Book {

	private int id;
	private String name;
	private String author;
	private String press;
	private Date pressTime;
	private String introduction;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPressTime() {
		return pressTime;
	}

	public void setPressTime(Date pressTime) {
		this.pressTime = pressTime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", press=" + press + ", pressTime=" + pressTime
				+ ", introduction=" + introduction + "]";
	}

	
	
	
}
