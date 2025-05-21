package com.tutorial.bookStore.Controller;

import com.tutorial.bookStore.Service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {

    @Autowired
    MyBookService myBookService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMYList(@PathVariable("id") int id){
        myBookService.deleteById(id);
        return "redirect:/my_books ";
    }
}
