package com.hibernateProject.LibraryManagementSystem.Services;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernateProject.LibraryManagementSystem.Model.Book;


public class BookManager {
	private Session session;
	private Transaction transaction;
	private Scanner sc;
	
	
	public BookManager(Session session, Transaction transaction, Scanner sc) {
		this.session = session;
		this.transaction = transaction;
		this.sc = sc;
	}
	
	public void addBook() {
		sc.nextLine();
		System.out.print("Enter the Book Title: ");
		String bookTitle = sc.nextLine();
		System.out.print("Enter Author Name: ");
		String author = sc.nextLine();
		System.out.print("Enter Catagory: ");
		String category = sc.nextLine();
		
		Book book = new Book(bookTitle, author, category);
		
		try {
			session.persist(book);
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void showAllBook() {
		Query<Book> query = session.createQuery("from Book", Book.class);
		List<Book> books = query.list();
		
		System.out.println("All Books");
		for(Book book : books) {
			System.out.print(book.getTitle() + " by " + book.getAuthor() + ": ");
			if(book.isIssued()) {
				System.out.println("Not Available");
			} else {
				System.out.println("Available");
			}
		}
	}
	
	public void categorySearch() {
		sc.nextLine();
		Query<String> cQuery = session.createQuery("select distinct category from Book", String.class);
		List<String> categories = cQuery.list();
		
		
		
		for(int i = 0; i < categories.size(); i++) {
			System.out.println((i+1) + ". " + categories.get(i));
		}
		
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		
		Query<Book> bookQuery = session.createQuery("from Book where category = :category", Book.class);
		bookQuery.setParameter("category", categories.get(choice - 1));
		List<Book> books = bookQuery.list();
		
		System.out.println("Books");
		for(Book book : books) {
			System.out.print(book.getTitle() + " by " + book.getAuthor() + ": ");
			if(book.isIssued()) {
				System.out.println("Not Available");
			} else {
				System.out.println("Available");
			}
		}
	}
}
