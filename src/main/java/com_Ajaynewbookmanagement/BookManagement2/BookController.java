package com_Ajaynewbookmanagement.BookManagement2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.List;

@RestController
public class BookController {



    private BookService bookService =new BookService();


    @PostMapping("/add-new-book")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        String str;
        str = bookService.addBook(book);
        return new ResponseEntity<>(str,HttpStatus.CREATED);
    }


    @GetMapping("/get-book")
    public ResponseEntity<Book>getBook(@RequestParam Integer id) {
        try{
            Book book=bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (BookNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/get-list-books")
    public ResponseEntity <List<Book>>  getBooks(){
        return new ResponseEntity<>(bookService.getBooks(),HttpStatus.OK) ;
    }

    @GetMapping("/get-book-by-name/{name}")
    public   ResponseEntity<Book>getBookByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(bookService.getBook(name),HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
//       for(Map.Entry<Integer,Book> entry: bookData.entrySet()){
//           if(entry.getValue().getTitle().equals(name))
//              return entry.getValue();
//        }
//       return null;
    }

//
    @PutMapping("/update-book-page")
    public ResponseEntity<Book> updatePages(@RequestParam Integer id,@RequestParam Integer pages){
        try {
               Book book=bookService.updatePages(id,pages);
               return new ResponseEntity<>(book,HttpStatus.CREATED);
        }catch (BookNotFoundException e){
             return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


      @DeleteMapping("delete-book/{id}")
      public String deleteBook(@PathVariable Integer id){
        bookData.remove(id);
        return "deleted id is"+id;
      }

}

