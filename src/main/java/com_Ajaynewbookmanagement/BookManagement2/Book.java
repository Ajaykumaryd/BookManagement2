package com_Ajaynewbookmanagement.BookManagement2;

import lombok.Getter;
import lombok.Setter;

@Getter  //Lombock Dependencies
@Setter //Lombock Dependencies
public class Book {
    private Integer id;
    private String title;
    private Integer pages;
    private String author;


    //Empty constructor
    public Book(){

    }

    public Book(Integer id, String title, Integer pages, String author) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.author = author;
    }
}
