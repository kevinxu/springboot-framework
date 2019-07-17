package com.example.demo.service;

import com.example.demo.domain.Book;

import java.util.List;

public interface IBookService {

    public void addBook(Book book);

    public void updateBookInfo(Book book);

    public Book findBook(int id);

    public void deleteBook(int id);

    public List<Book> findBookByAuthor(String author);

    public List<Book> getAllBooks();
}
