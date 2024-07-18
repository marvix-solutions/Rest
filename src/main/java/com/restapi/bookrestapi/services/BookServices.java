package com.restapi.bookrestapi.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.bookrestapi.dao.BookRepository;
import com.restapi.bookrestapi.model.Book;

@Component
public class BookServices {
    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(12, "Learn with Nabil", "Nabil"));
    // list.add(new Book(13, "Programmers", "Ayan"));
    // list.add(new Book(14, "Think in Java", "Hussain"));
    // }

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id) {
        // Stream for filtering the based on the Id;
        Book book = null;
        try {
            book = this.bookRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Adding the book
    public Book addBook(Book book) {
        Book result = this.bookRepository.save(book);
        return result;
    }

    // Deleting the book
    public void deleteBook(int id) {
        this.bookRepository.deleteById(id);
    }

    // update the book
    public void updateBook(Book book, int id) {
        book.setBookId(id);
        this.bookRepository.save(book);
    }
}
