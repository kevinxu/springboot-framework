package com.example.demo.service.impl;

import com.example.demo.domain.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void updateBookInfo(Book book) {
        bookMapper.update(book);
    }

    @Override
    public Book findBook(int id) {
        return bookMapper.find(id);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.delete(id);
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return bookMapper.findByAuthor(author);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }
}
