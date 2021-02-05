package com.study.testdemo.repository;

import com.study.testdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//这一层就是定义和数据库直接交互的借口，这里的JpaRepository里定义了很多操作数据库的方法，直接继承调用即可
public interface BookRepository extends JpaRepository<Book,Integer>{
}
