package com.nt.main;

public class MainClass {
	public static void main(String[] args) {
		Library library = new Library();
		library.AddBook("Java");
		library.AddBook("HTML");
		library.AddBook("CSS");
		library.AddBook("C");
		library.AddBook("C++");
		library.AddBook("PHP");
		library.AddBook("Spring Boot");
		library.AddBook("Javascript");
		library.AddBook("Oracle");
		library.AddBook("Mysql");
		library.AddBook("MongoDB");
		library.AddBook("Git");
		
        library.showAvilableBook();
        library.issueBook("C++");
        library.returnBook("C++");
        library.showAvilableBook();
	}
}
