package com_Ajaynewbookmanagement.BookManagement2;

import java.util.*;

public class BookRepository {
    private  Map<Integer,Book> bookData=new HashMap<>();

    public void add(Book book){

        bookData.put(book.getId(),book);
    }


        public Optional<Book> getById(Integer id) {
        if (bookData.containsKey(id)){
            Book bookToReturn=bookData.get(id);
            return Optional.of(bookToReturn);
    }
        return Optional.empty();
   }


    public    List<Book> getAll() {
        return new ArrayList<>(bookData.values());
    }


    public void update(Book book) {
        bookData.put(book.getId(), book);
    }
}
