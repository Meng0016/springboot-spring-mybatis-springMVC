package com.ydlclass.dao;

import com.ydlclass.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    List<Book> selectAll();
    List<Book> select(Book book);
    void insert(Book book);
    void delete(int id);
    void update(Book book);
    void batchinsert(@Param("books") List<Book> bookList);
    void batchdeleteByIds(@Param("ids")List<Integer> ids);
    Book  selectbyid(int id);
    int insertNoId(Book book);
}