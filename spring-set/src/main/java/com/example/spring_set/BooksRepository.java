package com.example.spring_set;
import java.util.*;

public interface BooksRepository {
    ArrayList<Books> getBooks();
    Books getBookId(int bookId);
    Books addBooks(Books book);
    Books updateBook(int bookId,Books book);
    void deleteBook(int bookid);
}
