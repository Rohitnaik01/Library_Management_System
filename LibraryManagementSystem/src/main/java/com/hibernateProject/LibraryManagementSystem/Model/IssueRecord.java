package com.hibernateProject.LibraryManagementSystem.Model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class IssueRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issueId;
	@ManyToOne
	private Book book;
	@ManyToOne
	private Member member;
	private LocalDate issuedDate;
	private LocalDate returnDate;
	
	
	public IssueRecord(Book book, Member member, LocalDate issuedDate, LocalDate returnDate) {
		this.book = book;
		this.member = member;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
	}
	
	public IssueRecord() {
		
	}

	@Override
	public String toString() {
		return "IssueRecord [issueId=" + issueId + ", book=" + book + ", member=" + member + ", issuedDate="
				+ issuedDate + ", returnDate=" + returnDate + "]";
	}
	
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
