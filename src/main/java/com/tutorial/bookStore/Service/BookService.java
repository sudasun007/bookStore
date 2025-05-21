package com.tutorial.bookStore.Service;

import com.tutorial.bookStore.Model.Book;
import com.tutorial.bookStore.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public void save(Book book){
        bookRepo.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book getBookById(int id){
        return bookRepo.findById(id).get();
    }

    public void deleteById(int id){
        bookRepo.deleteById(id);
    }

}
