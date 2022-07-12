package com.ydlclass.controller;


import com.ydlclass.service.BookService;
import com.ydlclass.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/app")
public class BookController {

    @Autowired
    @Qualifier("bookserviceimpl")
    private BookService bookService;



    @GetMapping("index")
    public String list(Model model){
        List<Book> books=bookService.getBookList();
        model.addAttribute("booklist",books);
        return "index";
    }

    @RequestMapping("addbook")
    public String toadd(){
        return "addbook";
    }

    @RequestMapping("insert")
    public String addbook(Book book){
        bookService.insert(book);
        return "redirect:/book/index";
    }

    @RequestMapping("toupdate")
    public String toupdate(int id,Model model){
        Book book=bookService.selectbyid(id);
        model.addAttribute("books",book);
        return "updatebook";
    }


    @RequestMapping("updatebook")
    public String updatebook(Book book){
        bookService.update(book);
        return "redirect:/book/index";
    }

    public String todelete(){

        return "";
    }
}


