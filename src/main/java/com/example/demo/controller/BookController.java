package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.pojo.ApiResponse;
import com.example.demo.service.IBookService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan({"com.example.demo.service"})
//@MapperScan("com.example.demo.mapper")
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ApiResponse getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        return new ApiResponse<>(0, "success", books);
    }
}
