package com.study.testdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {
//@id表示主键
//@GeneratedValue(strategy = GenerationType.IDENTITY) 表示自增，数据可设计的时候也要对应勾选自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
}
