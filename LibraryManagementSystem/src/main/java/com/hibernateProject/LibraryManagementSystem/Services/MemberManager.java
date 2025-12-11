package com.hibernateProject.LibraryManagementSystem.Services;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernateProject.LibraryManagementSystem.Model.Member;

public class MemberManager {
	private Session session;
	private Transaction transaction;
	private Scanner sc;
	private Member member;
	
	public MemberManager(Session session, Transaction transaction, Scanner sc) {
		this.session = session;
		this.transaction = transaction;
		this.sc = sc;
	}
	
	public boolean alreadyMember(String email) {
		Query<Member> query = session.createQuery("from Member where email = :email", Member.class);
		query.setParameter("email", email);
		member = query.uniqueResult();
		
		if(member != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addMember() {
		sc.nextLine();
		System.out.print("Enter Member Name: ");
		String memberName = sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		System.out.print("Enter Phone No.: ");
		String phone = sc.nextLine();
		
		if(!alreadyMember(email)) {
			member = new Member(memberName, email, phone);
			try {
				session.persist(member);
				transaction.commit();
			} catch(Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} else {
			System.out.println("Member Email already exists");
		}
	}
	
	public void showAllMember() {
		Query<Member> query = session.createQuery("from Member", Member.class);
		List<Member> members = query.list();
		
		System.out.println("All Members");
		for(Member member : members) {
			System.out.println(member.getName() + ": Mobile no: " + member.getPhone() + " Email: " + member.getEmail());
		}
	}
	
}
