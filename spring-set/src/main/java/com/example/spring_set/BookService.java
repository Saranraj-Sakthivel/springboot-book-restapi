package com.example.spring_set;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import com.example.spring_set.BooksRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.spring_set.Books;

public class BookService implements BooksRepository {
    private HashMap<Integer,Books> hmap = new HashMap<>();
    int uniqueBookId = 3;
    public BookService(){
        Books b1 = new Books(1,"sachin","sachinimageurl");
        Books b2 = new Books (2,"dhoni","dhoniimageurl");
        hmap.put(b1.getId(),b1);
        hmap.put(b2.getId(),b2);
    }
    @Override
    public ArrayList<Books> getBooks(){
        Collection<Books> booksCollection = hmap.values();
        ArrayList<Books> books = new ArrayList<>(booksCollection);
        return books;
    }
    @Override
    public Books getBookId(int bookId){
        Books book = hmap.get(bookId);
        if(book== null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }
    public Books addBooks(Books book){
        book.setId(uniqueBookId);
        hmap.put(uniqueBookId,book);
        uniqueBookId += 1;
        return  book;
    }

    public Books updateBook(int bookId,Books book) {
        Books exsitingBook = hmap.get(bookId);
        if (exsitingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (book.getName() != null) {
            exsitingBook.setName(book.getName());
        }
        if(book.getImageUrl()!=null){
            exsitingBook.setImageUrl(book.getImageUrl());
        }
        return exsitingBook;
    }
    public void deleteBook(int bookId){
        Books book = hmap.get(bookId);
        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            hmap.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
