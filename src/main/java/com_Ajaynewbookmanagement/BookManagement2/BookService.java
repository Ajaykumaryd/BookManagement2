package com_Ajaynewbookmanagement.BookManagement2;

public class BookService {

    private BookRepository bookRepository =new BookRepository();

    public String addBook(Book book){
    bookRepository.add(book);
    return "book added with id "+ book.getId();
    }

    public Book getBook(Integer id) {

    }
}
