package com.woniuxy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookTypeController {
    @Autowired
    BookTypeService bookTypeService;
    @RequestMapping("all")
    @ResponseBody
    public Result all(){
        long start = System.currentTimeMillis();
        List<BookType> types = bookTypeService.getAll();
        long end = System.currentTimeMillis();
        System.out.println("bookTypeService.getAll 耗时 "+(end-start)+" ms");
        return Result.successResult(types);
    }
}
