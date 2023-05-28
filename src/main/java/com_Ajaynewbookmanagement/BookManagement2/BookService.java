package com_Ajaynewbookmanagement.BookManagement2;

import java.util.List;
import java.util.Optional;

public class BookService {

    private BookRepository bookRepository =new BookRepository();

    public String addBook(Book book){
    bookRepository.add(book);
    return "book added with id "+ book.getId();
    }

    public Book getBook(Integer id) throws BookNotFoundException {
    Optional<Book> bookOptional=bookRepository.getById(id);
    if(bookOptional.isEmpty()){
       throw new BookNotFoundException(id);
    }
    return bookOptional.get();
    }


    public List<Book> getBooks() {
       return  bookRepository.getAll();
    }

    public Book getBook(String name) throws RuntimeException{
       List<Book> books= bookRepository.getAll();
       for(Book book:books){
           if(book.getTitle().equals(name)){
               return book;
           }
       }
       throw new RuntimeException("Book name is not found");
    }


    public Book updatePages(Integer id, Integer pages) throws BookNotFoundException {
     Book book=getBook(id);
     book.setPages(pages);
     bookRepository.update(book);
     return book;
    }



}
