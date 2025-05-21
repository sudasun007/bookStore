package com.tutorial.bookStore.Controller;

import com.tutorial.bookStore.Model.Book;
import com.tutorial.bookStore.Model.MyBookList;
import com.tutorial.bookStore.Service.BookService;
import com.tutorial.bookStore.Service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    MyBookService myBookService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ModelAndView("availableBooks","books",books);

    }

    @GetMapping("/my_books")
    public String getAllMyBooks(Model model){
        List<MyBookList> myBooks = myBookService.getAllMyBooks();
        model.addAttribute("myBooks",myBooks);
        return "myBooks";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @RequestMapping("/my_list/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }

}
