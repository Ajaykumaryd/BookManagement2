package com_Ajaynewbookmanagement.BookManagement2;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Integer id )
    {
        super("Book id is invalid"+id);
    }

   }
