package com.zgxh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yu Yang
 * @create 2020-02-27 16:12
 */
@Controller
public class PostController {

    @PostMapping(value = "/file")
    @ResponseBody
    public String handleFormUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        // file要求不能是null，之前用postman测试的时候遇到nullPointerException，是因为文件的key值与@RequestParam的value不对应，
        // 当不写@RequestParam时，编译时会自动保留MultipartFile的变量名"file"给value变量
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            return "success!";
        }
        return "failed!";
    }

    @PostMapping(value = "/files")
    @ResponseBody
    public String handleMultiFormUpload(@RequestParam(value = "files") MultipartFile[] files) throws IOException { // 多文件上传，name都要是"files"
        if (files.length > 0) {
            String fileName = files[0].getOriginalFilename();
            InputStream inputStream = files[0].getInputStream();
            System.out.println(files.length);
            return "success!";
        }
        return "failed!";
    }
}
