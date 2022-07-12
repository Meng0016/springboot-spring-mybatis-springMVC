package com.ydlclass.service.impl;

import com.ydlclass.dao.BookDao;
import com.ydlclass.entity.Book;
import com.ydlclass.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBookService implements BookService {


    @Autowired
    private BookDao bookDao;



    @Override
    public List<Book> getBookList() {
        return bookDao.selectAll();
    }

    @Override
    public List<Book> select(Book book) {
        return bookDao.select(book);
    }

    @Override
    public void insert(Book book) {
      bookDao.insert(book);
    }

    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }

    @Override
    public void batchinsert(List<Book> bookList) {
        bookDao.batchinsert(bookList);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void batchdeleteByIds(List<Integer> ids) {
        bookDao.batchdeleteByIds(ids);
    }

    @Override
    public Book selectbyid(int id) {
        return bookDao.selectbyid(id);

    }

    @Override
    public int insertNoId(Book book) {
       return bookDao.insertNoId(book);
    }

    public void setBookdao(BookDao bookdao) {
    }
}
