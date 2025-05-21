package com.tutorial.bookStore.Repo;

import com.tutorial.bookStore.Model.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepo extends JpaRepository<MyBookList,Integer> {

}
