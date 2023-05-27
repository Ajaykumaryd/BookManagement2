package com_Ajaynewbookmanagement.BookManagement2;

import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private  Map<Integer,Book> bookData=new HashMap<>();

    public void add(Book book){
    bookData.put(book.getId(),book);
    }

}
