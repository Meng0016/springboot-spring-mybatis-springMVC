package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    @GetMapping(value = "/basic_table")
    public String basicTable() {
        return "table/basic_table";
    }

    @GetMapping(value = "/dynamic_table")
    public String dynamicTable() {
        return "table/dynamic_table";
    }

    @GetMapping(value = "/editable_table")
    public String editTable() {
        return "table/editable_table";
    }

    @GetMapping(value = "/responsive_table")
    public String responsiveTable() {
        return "table/responsive_table";
    }
}
