package com.nt.main;

public class Library {
	String[] books;
	Integer no_Of_Book;

	public Library() {
		this.books = new String[100];
		this.no_Of_Book = 0;
	}

	void AddBook(String book) {
		this.books[no_Of_Book++] = book;
		System.out.println(book + " Book has been Added Successfully! ");
	}

	void showAvilableBook() {
		System.out.println("Available Book in Library.");
		for (String book : this.books) {
			if (book == null) {
				continue;
			}
			System.out.println(" * " + book);
		}
	}

	void issueBook(String book) {
		for (int i = 0; i < this.books.length; i++) {
			if (this.books[i].equals(book)) {
				System.out.println("The book has been Issued.");
				this.books[i] = null;
				return;
			}
		}
		System.out.println("This book dose not exist.");
	}

	void returnBook(String book) {
		AddBook(book);
	}
}
