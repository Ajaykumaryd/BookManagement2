package com_Ajaynewbookmanagement.BookManagement2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {



    private BookService bookService =new BookService();


    @PostMapping("/add-new-book")
    public ResponseEntity<String> addBook(@RequestBody Book book){

        String str= bookService.addBook(book);
        return new ResponseEntity<>(str,HttpStatus.CREATED) ;
    }


    @GetMapping("/get-book")
    public ResponseEntity<Book>getBook(@RequestParam Integer id) {
        try{
            Book book=bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (BookIdInvalidException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    //
//    @GetMapping("/get-list-books")
//    public List<Book> getBooks(){
//        return new ArrayList<>(bookData.values());
//    }
//
//    //get api by book name
//
//    @GetMapping("/get-book-by-name/{name}")
//    public Book getBookByName(@PathVariable String name){
//       for(Map.Entry<Integer,Book> entry: bookData.entrySet()){
//           if(entry.getValue().getTitle().equals(name))
//              return entry.getValue();
//        }
//       return null;
//    }
//
//
//    @PutMapping("/update-book-page")
//    public Book updatePages(@RequestParam Integer id,@RequestParam Integer pages){
//      Book book=bookData.get(id);
//      book.setPages(pages);
//      bookData.put(id,book);
//      return book;
//    }
//
////    @PutMapping("/update-book-page/{id}") //update-book-pages/1?pages=500
////    public Book updatePages(@PathVariable Integer id,@RequestParam Integer pages){
////        Book book=bookData.get(id);
////        book.setPages(pages);
////        bookData.put(id,book);
////        return book;
////    }
//
//      @DeleteMapping("delete-book/{id}")
//      public String deleteBook(@PathVariable Integer id){
//        bookData.remove(id);
//        return "deleted id is"+id;
//      }

}

