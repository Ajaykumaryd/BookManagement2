package com_Ajaynewbookmanagement.BookManagement2;

import java.util.Optional;

public class BookService {

    private BookRepository bookRepository =new BookRepository();

    public String addBook(Book book){
    bookRepository.add(book);
    return "book added with id "+ book.getId();
    }

    public Book getBook(Integer id) throws BookIdInvalidException {
    Optional<Book> bookOptional=bookRepository.getById(id);
    if(bookOptional.isEmpty()){
       throw new BookIdInvalidException(id);
    }
    return bookOptional.get();
    }



}
