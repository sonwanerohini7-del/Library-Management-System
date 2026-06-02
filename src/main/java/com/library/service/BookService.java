package com.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // single book
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // save + update
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    // delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}