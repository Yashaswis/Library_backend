package com.springboot.Library_management.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_Id")
	private int bookId;
	@Column(name = "bookname", length = 50, nullable = false, unique = true)
	private String bookname;
	@Column(name = "author", length = 50, nullable = false)
	private String author;
	private String date;
	@Column(name = "edition", length = 50, nullable = false, unique = true)
	private int edition;
	private float amount;

	public Books(int bookId, String bookname, String author, String date, int edition, int amount) {
		this.bookId = bookId;
		this.bookname = bookname;
		this.author = author;
		this.amount = amount;
		this.date = date;
		this.edition = edition;
	}

	public Books() {
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
