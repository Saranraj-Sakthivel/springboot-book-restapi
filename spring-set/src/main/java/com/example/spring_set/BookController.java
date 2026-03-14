package com.example.spring_set;
import org.springframework.web.bind.annotation.*;
import com.example.spring_set.BookService;
import java.util.ArrayList;

@RestController
public class BookController {
    BookService bookService = new BookService();
    @GetMapping("/name")
    public ArrayList<Books> getbooks(){
        return bookService.getBooks();
    }

    @GetMapping("/name/{bookId}")
    public Books getBookId(@PathVariable("bookId") int bookId){
        return bookService.getBookId(bookId);
    }
    @PostMapping("/books")
    public Books addBooks(@RequestBody Books book){
        return bookService.addBooks(book);
    }

    @PutMapping("/books/{bookId}")
    public Books updateBook(@PathVariable("bookId") int bookId,@RequestBody Books book){
        return bookService.updateBook(bookId,book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
    }
}
