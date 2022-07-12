package com.ydlclass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private  static final Long serialVersionUID = 1L;
    private  Integer id;
    private String bookname;
    private String bookauthor;
    private String bookpublish;
}
