package com.wangpeng.bms.web;

import com.wangpeng.bms.model.BookInfo;
import com.wangpeng.bms.service.BookInfoService;
import com.wangpeng.bms.utils.MyResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookInfoController {

    @Resource
    private BookInfoService bookInfoService;

    @GetMapping("/list")
    public MyResult list(@RequestParam Map<String, Object> params) {
        List<BookInfo> books = bookInfoService.queryBooks(params);
        return MyResult.ok(books);
    }

    @PostMapping("/add")
    public MyResult add(@RequestBody BookInfo bookInfo) {
        Boolean res = bookInfoService.addBook(bookInfo);
        if(res) {
            return MyResult.ok();
        } else {
            return MyResult.error("添加失败");
        }
    }

    @PostMapping("/update")
    public MyResult update(@RequestBody BookInfo bookInfo) {
        Boolean res = bookInfoService.updateBook(bookInfo);
        if(res) {
            return MyResult.ok();
        } else {
            return MyResult.error("更新失败");
        }
    }

    @PostMapping("/delete")
    public MyResult delete(@RequestBody BookInfo bookInfo) {
        Boolean res = bookInfoService.deleteBook(bookInfo);
        if(res) {
            return MyResult.ok();
        } else {
            return MyResult.error("删除失败");
        }
    }
}