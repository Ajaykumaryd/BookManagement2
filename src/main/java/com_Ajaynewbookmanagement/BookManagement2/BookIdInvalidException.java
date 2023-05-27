package com_Ajaynewbookmanagement.BookManagement2;

public class BookIdInvalidException extends RuntimeException{
    public BookIdInvalidException(Integer id )
    {
        super("Book id is invalid"+id);
    }

   }
