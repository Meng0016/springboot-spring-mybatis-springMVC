package com.ydlclass.service;

import com.ydlclass.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getBookList();
    List<Book> select(Book book);
    void insert(Book book);
    void delete(int id);
    void batchinsert(List<Book> bookList);
    void update(Book book);
    void batchdeleteByIds(List<Integer> ids);
    Book  selectbyid(int id);
    int insertNoId(Book book);
}
