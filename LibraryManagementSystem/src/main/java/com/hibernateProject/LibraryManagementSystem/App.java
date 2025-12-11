package com.hibernateProject.LibraryManagementSystem;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernateProject.LibraryManagementSystem.Model.Book;
import com.hibernateProject.LibraryManagementSystem.Model.IssueRecord;
import com.hibernateProject.LibraryManagementSystem.Model.Member;
import com.hibernateProject.LibraryManagementSystem.Services.BookManager;
import com.hibernateProject.LibraryManagementSystem.Services.MemberManager;

public class App 
{
	static private Session session;
	static private Transaction transaction;
	static private Scanner sc;
	static private BookManager bookManager;
	static private MemberManager memberManager;
	
    public static void main( String[] args)
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Member.class).addAnnotatedClass(IssueRecord.class);
        SessionFactory sf = config.buildSessionFactory();
        session = sf.openSession();
        transaction = session.beginTransaction();
        sc = new Scanner(System.in);
        
        bookManager = new BookManager(session, transaction, sc);
        memberManager = new MemberManager(session, transaction, sc); 
        
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. View Books");
        System.out.println("4. View Members");
        
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        switch(choice) {
        	case 1: bookManager.addBook();
        	break;
        	case 2: memberManager.addMember();
        	break;
        	case 3: bookManager.showAllBook();
        	break;
        	case 4: memberManager.showAllMember();
        	break;
        	case 5: bookManager.categorySearch();
        	break;
        	default: System.out.println("Invalid Choice");
        	break;
        }
                
        
        
    }
}
