package com.library.entity;

import jakarta.persistence.*;

@Entity
public class IssueBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    private String bookName;

    private String issueDate;

    private String returnDate;

    // ✅ Default constructor
    public IssueBook() {
    }

    // ✅ Parameterized constructor
    public IssueBook(Long id, String studentName, String bookName, String issueDate, String returnDate) {
        this.id = id;
        this.studentName = studentName;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    // ✅ Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}