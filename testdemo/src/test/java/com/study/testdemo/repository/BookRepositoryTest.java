package com.study.testdemo.repository;

import com.study.testdemo.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//每写一个接口就测试一下能不能使用
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private  BookRepository bookRepository;
    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }
    @Test
    void save(){
        Book book = new Book();
        book.setName("JAVA Spring Boot");
        book.setAuthor("zhangsan");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }
}