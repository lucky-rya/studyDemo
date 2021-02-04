package com.study.testdemo.controller;


import com.study.testdemo.entity.Book;
import com.study.testdemo.repository.BookRepository;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
//   记得加注解
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size")Integer size)  {
    Pageable pageable = PageRequest.of(page-1,size);
       return  bookRepository.findAll(pageable);
    }
    @PostMapping("/save")
    public  String save(@RequestBody Book book){
        Book res = bookRepository.save(book);
        if(res!=null){
            return  "success";
        }else {
            return  "error";
        }
    }
    @PutMapping("/update/{id}")
    public  String update(@PathVariable("id") Integer id,@RequestBody Book book){
       Book temp =  bookRepository.findById(id).get();
       temp.setName(book.getName());
       temp.setAuthor(book.getAuthor());

        Book res = bookRepository.save(temp);
        if(res!=null){
            return  "success";
        }else {
            return  "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Book findBiId(@PathVariable("id") Integer id){
        return  bookRepository.findById(id).get();
    }
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable("id") Integer id){
         bookRepository.deleteById(id);

    }

}
