package com.example.demo.mapper;

import com.example.demo.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    public void insert(Book book);

    public void update(Book book);

    public void delete(int id);

    public Book find(int id);

    public List<Book> findByAuthor(String author);

    public List<Book> getAllBooks();
}
