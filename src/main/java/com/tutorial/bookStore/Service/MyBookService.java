package com.tutorial.bookStore.Service;

import com.tutorial.bookStore.Model.MyBookList;
import com.tutorial.bookStore.Repo.MyBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {

    @Autowired
    MyBookRepo myBookRepo;

    public void saveMyBooks(MyBookList myBookList){
        myBookRepo.save(myBookList);
    }


    public List<MyBookList> getAllMyBooks(){
        return myBookRepo.findAll();
    }

    public void deleteById(int id){
        myBookRepo.deleteById(id);
    }
}
